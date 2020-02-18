package com.wengxs.cloud.service.impl;

import cn.hutool.core.util.ArrayUtil;
import com.wengxs.cloud.dto.UserInfo;
import com.wengxs.cloud.model.SysMenu;
import com.wengxs.cloud.service.SysUserService;
import com.wengxs.cloud.mapper.SysMenuMapper;
import com.wengxs.cloud.mapper.SysRoleMapper;
import com.wengxs.cloud.mapper.SysUserMapper;
import com.wengxs.cloud.model.SysRole;
import com.wengxs.cloud.model.SysUser;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Zorg
 * 2019-08-20 18:13
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public UserInfo findUserInfo(String username) {
        UserInfo userInfo = new UserInfo();
        SysUser sysUser = sysUserMapper.selectByUsername(username);
        if (sysUser != null) {
            userInfo.setSysUser(sysUser);
            List<SysRole> sysRoles = sysRoleMapper.selectByUserId(sysUser.getId());

            // 获取角色列表
            List<Long> roleIds = sysRoles.stream().map(SysRole::getId).collect(Collectors.toList());
            userInfo.setRoles(ArrayUtil.toArray(roleIds, Long.class));

            // 获取权限列表
            List<String> permissions = sysMenuMapper.selectByUserId(sysUser.getId())
                    .stream()
                    .filter(menu -> StringUtils.isNotEmpty(menu.getPermission()))
                    .map(SysMenu::getPermission)
                    .collect(Collectors.toList());
            userInfo.setPermissions(ArrayUtil.toArray(permissions, String.class));
            return userInfo;
        }
        return null;
    }
}
