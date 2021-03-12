package com.wengxs.cloud.service.impl;

import com.wengxs.cloud.core.R;
import com.wengxs.cloud.dto.UserInfo;
import com.wengxs.cloud.feign.SysUserFeign;
import com.wengxs.cloud.model.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Zorg
 * 2020-02-10 21:06
 */
@Component
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserFeign sysUserFeign;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("当前登录请求用户：{}", username);
        R<UserInfo> r =  sysUserFeign.userInfo(username);
        UserInfo userInfo = r.getData();
        if (userInfo == null || userInfo.getSysUser() == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        Long[] roles = userInfo.getRoles();
        String[] permissions = userInfo.getPermissions();
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (Long role : roles) {
            // 用户可以访问的资源名称（或者说用户所拥有的权限） 注意：必须"ROLE_"开头
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        }
        for (String permission : permissions) {
            if (StringUtils.hasText(permission))
                authorities.add(new SimpleGrantedAuthority(permission));
        }

        SysUser sysUser = userInfo.getSysUser();
        return new User(username, sysUser.getPassword(),
                sysUser.getIsEnabled(), true, true, true,
                authorities);
    }

}
