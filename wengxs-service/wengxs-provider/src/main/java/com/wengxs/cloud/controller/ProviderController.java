package com.wengxs.cloud.controller;

import com.wengxs.cloud.core.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Zorg
 * 2021/3/15 下午5:31
 */
@RestController
@RequestMapping("/provider")
public class ProviderController {

    @PostMapping("/create")
    public R<String> create() {
        throw new RuntimeException("error");
//        return R.ok("成功啦");
    }
}
