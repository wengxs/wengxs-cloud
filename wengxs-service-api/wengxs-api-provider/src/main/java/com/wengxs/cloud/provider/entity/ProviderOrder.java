package com.wengxs.cloud.provider.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.wengxs.cloud.core.base.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Zorg
 * 2021/3/16 上午10:15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("provider_order")
public class ProviderOrder extends BaseEntity<Long> {

    private String orderNo;

    private Integer qty;

}
