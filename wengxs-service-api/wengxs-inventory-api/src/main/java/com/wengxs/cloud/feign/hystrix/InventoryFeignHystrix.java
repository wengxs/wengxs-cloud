package com.wengxs.cloud.feign.hystrix;

import com.wengxs.cloud.core.util.R;
import com.wengxs.cloud.feign.InventoryFeign;
import com.wengxs.cloud.model.Inventory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by Zorg
 * 2019-08-15 15:22
 */
@Component
@Slf4j
public class InventoryFeignHystrix implements InventoryFeign {

    @Override
    public R<Inventory> select(Long goodsId) {
        log.error("<wengxs-inventory>:/inventory -> goodsId:{}", goodsId);
        return null;
    }

}
