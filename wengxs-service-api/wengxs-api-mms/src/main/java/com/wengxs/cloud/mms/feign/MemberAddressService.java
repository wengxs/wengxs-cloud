package com.wengxs.cloud.mms.feign;

import com.wengxs.cloud.mms.feign.fallback.MemberAddressServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Created by Zorg
 * 2020-03-13 15:24
 */
@FeignClient(value = "wengxs-mms", fallback = MemberAddressServiceHystrix.class)
public interface MemberAddressService {
}
