package com.wengxs.cloud.feign;

import com.wengxs.cloud.core.R;
import com.wengxs.cloud.feign.hystrix.ProviderFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by Zorg
 * 2021/3/15 下午6:10
 */
@FeignClient(value = "wengxs-provider", fallback = ProviderFeignHystrix.class)
public interface ProviderFeign {

    @PostMapping("/provider/create")
    R<String> create();
}
