package com.wengxs.cloud.upms.service;

import com.wengxs.cloud.upms.dto.UserInfo;

/**
 * Created by Zorg
 * 2019-08-20 18:13
 */
public interface SysUserService {

    UserInfo findUserInfo(String username);
}
