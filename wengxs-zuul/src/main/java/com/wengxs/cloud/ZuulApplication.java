package com.wengxs.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by Zorg
 * 2020-02-09 23:58
 */
@SpringCloudApplication
@EnableZuulProxy
@EnableOAuth2Sso
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

}
