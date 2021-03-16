package com.wengxs.cloud.mms.feign;

import com.wengxs.cloud.mms.feign.fallback.MemberServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "wengxs-mms", fallback = MemberServiceHystrix.class)
public interface MemberService {

}
