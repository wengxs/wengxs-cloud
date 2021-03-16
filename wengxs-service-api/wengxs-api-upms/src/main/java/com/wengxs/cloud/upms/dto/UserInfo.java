package com.wengxs.cloud.upms.dto;

import com.wengxs.cloud.upms.model.SysUser;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Zorg
 * 2019-08-20 18:09
 */
@Data
public class UserInfo implements Serializable {

    private SysUser sysUser;

    private Long[] roles;

    private String[] permissions;

}
