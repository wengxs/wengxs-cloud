package com.wengxs.cloud.controller;

import com.wengxs.cloud.core.util.R;
import com.wengxs.cloud.dto.UserInfo;
import com.wengxs.cloud.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Zorg
 * 2019-08-15 11:49
 */
@RequestMapping("/user")
@RestController
@Slf4j
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/info")
    public R findByUsername(@RequestParam String username) {
        log.info("查找用户");
        UserInfo userInfo = sysUserService.findUserInfo(username);
        return R.success(userInfo);
    }

    @GetMapping("/hi")
    @PreAuthorize("hasAuthority('admin:user:query')")
    public R hello() {
        return R.success("你好啊");
    }

}
