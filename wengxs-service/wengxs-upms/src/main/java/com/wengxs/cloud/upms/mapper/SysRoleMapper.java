package com.wengxs.cloud.upms.mapper;

import com.wengxs.cloud.upms.model.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Zorg
 * 2019-08-20 18:17
 */
@Mapper
public interface SysRoleMapper {

    @Select("SELECT DISTINCT a.* FROM sys_role a LEFT JOIN sys_user_role b ON b.role_id=a.id WHERE b.user_id=#{userId}")
    List<SysRole> selectByUserId(Long userId);
}
