package com.niuma.huaapiorder.service.impl;

import com.niuma.huaapicommon.model.entity.Order;
import com.niuma.huaapicommon.service.InnerOrderService;
import com.niuma.huaapiorder.service.OrderService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author niuma
 * @create 2023-05-11 23:00
 */
@DubboService
public class InnerOrderServiceImpl implements InnerOrderService {
    @Resource
    OrderService orderService;
    @Override
    public List<Order> listTopBuyInterfaceInfo(int limit) {
        return orderService.listTopBuyInterfaceInfo(limit);
    }
}
