package com.wengxs.cloud.oms.service.impl;

import com.wengxs.cloud.oms.mapper.OrderMapper;
import com.wengxs.cloud.oms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void pay(String sn) {
        orderMapper.updateStatus(sn, 1);


    }
}
