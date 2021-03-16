package com.wengxs.cloud.oms.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单信息
 */
@Data
public class Order {

    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /** 订单号 */
    private String sn;

    /** 订单状态[0未付款，1已付款，。。。] */
    private Integer status;

    /** 商品名称 */
    private String goodsName;

    /** 商品ID */
    private Long goodsId;

    /** 购买数量 */
    private Integer number;

    /** 总价 */
    private BigDecimal total;

    /** 单价 */
    private BigDecimal price;

    /** 会员ID */
    private Long memberId;

}
