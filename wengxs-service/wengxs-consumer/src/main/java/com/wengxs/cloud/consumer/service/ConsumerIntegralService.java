package com.wengxs.cloud.consumer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wengxs.cloud.consumer.entity.ConsumerIntegral;
import com.wengxs.cloud.provider.entity.ProviderOrder;

/**
 * Created by Zorg
 * 2021/3/16 下午1:46
 */
public interface ConsumerIntegralService extends IService<ConsumerIntegral> {

    ProviderOrder createOrder(ProviderOrder providerOrder);
}
