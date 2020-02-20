package com.wengxs.cloud.feign;

import com.wengxs.cloud.core.util.R;
import com.wengxs.cloud.feign.hystrix.InventoryFeignHystrix;
import com.wengxs.cloud.model.Inventory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Zorg
 * 2019-08-15 15:03
 */
@FeignClient(value = "wengxs-inventory", fallback = InventoryFeignHystrix.class)
public interface InventoryFeign {

    /**
     * @return R
     */
    @GetMapping("/inventory")
    R<Inventory> select(@RequestParam Long goodsId);

}
