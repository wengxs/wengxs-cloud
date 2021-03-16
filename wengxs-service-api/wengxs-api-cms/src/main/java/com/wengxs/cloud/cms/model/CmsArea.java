package com.wengxs.cloud.cms.model;

import lombok.Data;

/**
 * 地区信息
 * Created by Zorg
 * 2020-03-13 15:40
 */
@Data
public class CmsArea {

    private Integer areaCode;

    private String name;

    private String fullName;

    private Integer parentCode;

    private Integer level;

}
