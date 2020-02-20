package com.wengxs.cloud.controller;

import com.wengxs.cloud.core.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
@Slf4j
public class InventoryController {

    @GetMapping
    public R select(@RequestParam Long goodsId) {
        log.info("查询库存 -> goodsId:{}", goodsId);
        return R.success();
    }

}
