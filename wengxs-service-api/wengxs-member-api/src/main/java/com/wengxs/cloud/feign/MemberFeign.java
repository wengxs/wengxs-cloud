package com.wengxs.cloud.feign;

import com.wengxs.cloud.core.util.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "wengxs-member")
public interface MemberFeign {

    @PostMapping("/member/integral")
    public R addIntegral(@RequestParam Long memberId, Integer integral);
}
