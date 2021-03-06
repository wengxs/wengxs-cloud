package com.wengxs.cloud.mapper;

import com.wengxs.cloud.model.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Zorg
 * 2019-08-20 18:17
 */
@Mapper
public interface SysUserMapper {

    @Select("select * from sys_user where username=#{username}")
    SysUser selectByUsername(String username);

}
