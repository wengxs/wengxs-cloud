package com.wengxs.cloud.service;

import com.wengxs.cloud.mq.sender.MessageSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Zorg
 * 2020-03-08 04:28
 */
@Component
@Slf4j
public class MessageService {

    @Autowired
    private MessageSender messageSender;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void send(String message) {
        log.info("发送消息：{}", message);
        String messageId = System.currentTimeMillis() + "$" + UUID.randomUUID().toString();

        // 消息可靠性投递 - 消息记录入库
        Map<String, Object> brokerMessageLog = new HashMap<>();
        brokerMessageLog.put("messageId", messageId);
        brokerMessageLog.put("message", message);
        brokerMessageLog.put("tryCount", 0);
        brokerMessageLog.put("status", "sending");
        brokerMessageLog.put("nextRetry", System.currentTimeMillis() + 60 * 1000);
        brokerMessageLog.put("createTime", new Date());
        brokerMessageLog.put("updateTime", new Date());
        redisTemplate.opsForHash().putAll("broker_message_log_" + messageId, brokerMessageLog);
        redisTemplate.opsForList().rightPush("broker_message_log_queue", messageId);

        log.info("投递记录：{}", brokerMessageLog);

        messageSender.send(messageId, message);
    }
}
