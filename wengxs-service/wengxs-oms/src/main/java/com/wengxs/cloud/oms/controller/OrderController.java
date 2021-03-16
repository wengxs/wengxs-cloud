package com.wengxs.cloud.oms.controller;

import com.wengxs.cloud.core.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @PostMapping
    public R create() {
        return R.ok();
    }

}
