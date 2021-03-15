package com.wengxs.cloud.mq.listener;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Zorg
 * 2020-03-08 01:42
 */
@Component
@Slf4j
public class MessageListener {

    @RabbitListener(bindings = {@QueueBinding(
            value = @Queue(value = "message-queue", durable = "true"),
            exchange = @Exchange(value = "message-exchange", durable = "true", type = "topic"),
            key = "message.*"
    )})
    @RabbitHandler
    public void messageHandler(@Payload String message, @Headers Map<String, Object> headers, Channel channel) throws IOException {
        log.info("处理消息队列 --> {}", message);

        // 手动确认
        long deliveryTag = (long) headers.get(AmqpHeaders.DELIVERY_TAG);
        channel.basicAck(deliveryTag, false);
    }
}
