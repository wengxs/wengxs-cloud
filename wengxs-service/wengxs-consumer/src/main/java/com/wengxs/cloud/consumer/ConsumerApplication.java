package com.wengxs.cloud.consumer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Zorg
 * 2021/3/15 下午5:24
 */
@SpringCloudApplication
//@SpringBootApplication
//@EnableDiscoveryClient
@ComponentScan(basePackages = "com.wengxs.cloud")
@EnableFeignClients
@MapperScan("com.wengxs.cloud.consumer.mapper")
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}
