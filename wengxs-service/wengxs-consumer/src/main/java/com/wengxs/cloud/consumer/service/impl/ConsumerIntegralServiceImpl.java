package com.wengxs.cloud.consumer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wengxs.cloud.consumer.entity.ConsumerIntegral;
import com.wengxs.cloud.consumer.mapper.ConsumerIntegralMapper;
import com.wengxs.cloud.consumer.service.ConsumerIntegralService;
import com.wengxs.cloud.core.R;
import com.wengxs.cloud.provider.entity.ProviderOrder;
import com.wengxs.cloud.provider.feign.ProviderOrderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Date;

/**
 * Created by Zorg
 * 2021/3/16 下午1:47
 */
@Service
public class ConsumerIntegralServiceImpl extends ServiceImpl<ConsumerIntegralMapper, ConsumerIntegral>
        implements ConsumerIntegralService {

    @Autowired
    private ProviderOrderClient providerOrderClient;

    @Override
    @Transactional
    public ProviderOrder createOrder(ProviderOrder providerOrder) {
        ConsumerIntegral consumerIntegral = new ConsumerIntegral();
        consumerIntegral.setConsumerId(1L);
        consumerIntegral.setIntegral(1);
        consumerIntegral.setUpdateTime(new Date());
        save(consumerIntegral);
        R<ProviderOrder> r = providerOrderClient.create(providerOrder);
        Assert.isTrue(r.isOk(), r.getMessage());
        return r.getData();
    }
}
