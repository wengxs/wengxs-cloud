package com.wengxs.cloud.consumer.controller;

import com.wengxs.cloud.core.R;
import com.wengxs.cloud.provider.entity.ProviderOrder;
import com.wengxs.cloud.provider.feign.ProviderOrderClient;
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

    @Autowired
    private ProviderOrderClient providerOrderClient;

    @GetMapping("/get")
    public R<?> create() {
        ProviderOrder providerOrder = new ProviderOrder();
        providerOrder.setOrderNo(System.currentTimeMillis() + "");
        providerOrder.setQty(1);
        return providerOrderClient.create(providerOrder);
    }

}
