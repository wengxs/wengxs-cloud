package com.wengxs.cloud.feign;

import com.wengxs.cloud.feign.hystrix.MemberAddressServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Created by Zorg
 * 2020-03-13 15:24
 */
@FeignClient(value = "wengxs-mms", fallback = MemberAddressServiceHystrix.class)
public interface MemberAddressService {
}
