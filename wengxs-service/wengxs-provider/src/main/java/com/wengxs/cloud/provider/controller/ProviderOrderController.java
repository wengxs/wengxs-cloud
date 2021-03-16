package com.wengxs.cloud.provider.controller;

import com.wengxs.cloud.core.R;
import com.wengxs.cloud.provider.entity.ProviderOrder;
import com.wengxs.cloud.provider.service.ProviderOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Zorg
 * 2021/3/15 下午5:31
 */
@RestController
@RequestMapping("/provider/order")
public class ProviderOrderController {

    @Autowired
    private ProviderOrderService providerOrderService;

    @PostMapping("/create")
    public R<ProviderOrder> create(@RequestBody ProviderOrder providerOrder) {
        providerOrderService.save(providerOrder);
        return R.ok(providerOrder);
    }
}
