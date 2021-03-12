package com.wengxs.cloud.feign;

import com.wengxs.cloud.feign.hystrix.MemberServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "wengxs-mms", fallback = MemberServiceHystrix.class)
public interface MemberService {

}
