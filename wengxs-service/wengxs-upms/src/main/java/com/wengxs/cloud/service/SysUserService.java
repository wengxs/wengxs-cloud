package com.wengxs.cloud.service;

import com.wengxs.cloud.dto.UserInfo;

/**
 * Created by Zorg
 * 2019-08-20 18:13
 */
public interface SysUserService {

    UserInfo findUserInfo(String username);
}
