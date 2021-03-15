package com.wengxs.cloud.mq.sender;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Zorg
 * 2020-03-08 02:16
 */
@Component
@Slf4j
public class MessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void send(String messageId, String message) {

        rabbitTemplate.setConfirmCallback(confirmCallback);
        rabbitTemplate.convertAndSend(
                "message-exchange",
                "message.*",
                message,
                new CorrelationData(messageId));
    }

    /** 消息可靠性投递 - 回调函数：confirm确认 */
    private final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {

        @Override
        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
            log.info("消息可靠性投递confirm确认: {}, {}, {}", correlationData.getId(), ack, cause);
            if (ack) {
                // 消息投递成功
                redisTemplate.opsForHash().put("broker_message_log_" + correlationData.getId(),
                        "status", "success");
                redisTemplate.opsForHash().put("broker_message_log_" + correlationData.getId(),
                        "updateTime", new Date());
            } else {
                // 消息投递失败，进行重试或者补偿操作

            }
        }
    };

}
