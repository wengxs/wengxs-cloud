package com.wengxs.cloud.cms.feign;

import com.wengxs.cloud.cms.feign.fallback.CmsAreaServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Created by Zorg
 * 2020-03-13 15:50
 */
@FeignClient(value = "wengxs-cms", fallback = CmsAreaServiceHystrix.class)
public interface CmsAreaService {

//    @GetMapping()
}
