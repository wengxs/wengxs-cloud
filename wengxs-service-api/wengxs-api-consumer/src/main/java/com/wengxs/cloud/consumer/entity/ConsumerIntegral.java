package com.wengxs.cloud.consumer.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.wengxs.cloud.core.base.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Zorg
 * 2021/3/16 下午1:41
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("consumer_integral")
public class ConsumerIntegral extends BaseEntity<Long> {

    private Long consumerId;

    private Integer integral;
}
