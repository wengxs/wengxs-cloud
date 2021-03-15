package com.wengxs.cloud.mq.sender;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Zorg
 * 2020-03-08 02:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageSenderTest {

    @Autowired
    private MessageSender messageSender;

    @Test
    public void send() {
        messageSender.send("123", "你好啊");
    }
}