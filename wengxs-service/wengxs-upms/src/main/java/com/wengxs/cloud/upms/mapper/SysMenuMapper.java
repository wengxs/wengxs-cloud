package com.wengxs.cloud.upms.mapper;

import com.wengxs.cloud.upms.model.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Zorg
 * 2019-08-20 18:17
 */
@Mapper
public interface SysMenuMapper {

    @Select("SELECT DISTINCT a.* FROM sys_menu a " +
            "INNER JOIN sys_role_menu b ON a.id = b.menu_id " +
            "INNER JOIN sys_user_role c ON c.role_id = b.role_id " +
            "WHERE c.user_id = #{userId} ORDER BY a.sort")
    List<SysMenu> selectByUserId(Long userId);
}
