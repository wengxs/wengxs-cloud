package com.wengxs.cloud.controller;

import com.wengxs.cloud.core.util.R;
import com.wengxs.cloud.feign.InventoryFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/goods")
@RestController
@Slf4j
public class GoodsController {

    @Autowired
    private InventoryFeign inventoryFeign;

    @GetMapping("/stock")
    public R selectStock(@RequestParam Long goodsId) {
        log.info("查询商品库存 -> goodsId:{}", goodsId);
        inventoryFeign.select(goodsId);
        return R.success();
    }
}
