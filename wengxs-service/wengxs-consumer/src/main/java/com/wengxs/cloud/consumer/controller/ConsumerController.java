package com.wengxs.cloud.consumer.controller;

import com.wengxs.cloud.core.R;
import com.wengxs.cloud.provider.feign.ProviderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Zorg
 * 2021/3/15 下午5:41
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

//    @Autowired
//    private RestTemplate restTemplate;
    @Autowired
    private ProviderFeign providerFeign;

    @GetMapping("/get")
    public R<?> create() {
//        return restTemplate.postForObject("http://localhost:8011/provider/create", null, R.class);
        return providerFeign.create();
    }

}
