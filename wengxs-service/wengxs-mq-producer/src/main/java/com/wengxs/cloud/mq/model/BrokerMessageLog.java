package com.wengxs.cloud.mq.model;

import lombok.Data;

import java.util.Date;

/**
 * MQ消息记录
 * Created by Zorg
 * 2020-03-08 03:29
 */
@Data
public class BrokerMessageLog {

    /** 消息唯一ID */
    private String messageId;

    /** 消息内容 */
    private String message;

    /** 重试次数 */
    private Integer tryCount = 0;

    /** 消息投递状态 */
    private Integer status;

    /** 下次重试时间 */
    private Date nextRetry;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

}
