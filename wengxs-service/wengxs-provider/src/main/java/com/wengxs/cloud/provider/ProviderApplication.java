package com.wengxs.cloud.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by Zorg
 * 2021/3/15 下午2:58
 */
@SpringCloudApplication
@EnableFeignClients
@MapperScan("com.wengxs.cloud.cms.mapper")
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }
}
