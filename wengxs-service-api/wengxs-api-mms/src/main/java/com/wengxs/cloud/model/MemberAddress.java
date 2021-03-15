package com.wengxs.cloud.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 用户地址信息
 * Created by Zorg
 * 2020-03-13 14:58
 */
@Data
public class MemberAddress {

    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /** 用户ID */
    private Long memberId;

    /** 收件人 */
    private String addressee;

    /** 收件电话 */
    private String mobile;

    /** 地区编码 */
    private Long areaCode;

    /** 地区名称 */
    private String areaName;

    /** 详细地址 */
    private String address;

    /** 是否默认 */
    private Integer isDefault;

    /** 标签 */
    private String tag;

}
