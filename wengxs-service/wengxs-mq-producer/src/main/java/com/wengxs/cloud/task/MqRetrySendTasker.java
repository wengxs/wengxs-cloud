package com.wengxs.cloud.task;

import com.wengxs.cloud.mq.sender.MessageSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by Zorg
 * 2020-03-08 04:42
 */
@Component
@Slf4j
public class MqRetrySendTasker {

    @Autowired
    private MessageSender messageSender;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 项目启动后3秒钟开启任务，每隔5秒钟执行任务
     */
    @Scheduled(initialDelay = 3000, fixedDelay = 5000)
    public void reSend() {
        log.info("-----定时任务开始-----");
//        Long queueSize = redisTemplate.opsForList().size("broker_message_log_queue");
//        if (queueSize != null && queueSize > 0) {
//
//        }
        String messageId = (String) redisTemplate.opsForList().leftPop("broker_message_log_queue");
        if (messageId != null) {
            Map<Object, Object> sendLog = redisTemplate.opsForHash().entries("broker_message_log_" + messageId);
            if (sendLog.get("status") != null && sendLog.get("status").equals("sending")) {
                log.info("消息重新发送：{}", messageId);
                String message = (String) sendLog.get("message");
                redisTemplate.opsForList().rightPush("broker_message_log_queue", messageId);
                messageSender.send(messageId, message);
            }
        }
    }

}
