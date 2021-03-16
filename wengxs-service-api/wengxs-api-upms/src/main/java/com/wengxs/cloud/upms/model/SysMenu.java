package com.wengxs.cloud.upms.model;

import lombok.Data;

/**
 * 菜单权限
 * Created by Zorg
 * 2019-08-15 11:45
 */
@Data
public class SysMenu {

    private Long id;

    /** 上级ID */
    private Long parentId;

    /** 菜单权限名称 */
    private String name;

    /** 图标 */
    private String icon;

    /** 类型（0菜单 1按钮） */
    private Integer type;

    /** 权限标识 */
    private String permission;

    /** 排序 */
    private Integer sort;

    /** 路径URL */
    private String path;

    /** VUE页面组件 */
    private String component;

    /** 路由缓冲 */
    private String keepAlive;

}
