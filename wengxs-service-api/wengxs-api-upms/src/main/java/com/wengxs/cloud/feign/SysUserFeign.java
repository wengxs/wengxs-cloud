package com.wengxs.cloud.feign;

import com.wengxs.cloud.core.R;
import com.wengxs.cloud.dto.UserInfo;
import com.wengxs.cloud.feign.hystrix.SysUserFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Zorg
 * 2019-08-15 15:03
 */
@FeignClient(value = "wengxs-upms", fallback = SysUserFeignHystrix.class)
public interface SysUserFeign {

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return R
     */
    @GetMapping("/user/info")
    R<UserInfo> userInfo(@RequestParam("username") String username);

}
