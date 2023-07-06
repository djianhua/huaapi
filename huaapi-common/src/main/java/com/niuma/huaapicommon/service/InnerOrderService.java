package com.niuma.huaapicommon.service;

import com.niuma.huaapicommon.model.entity.Order;

import java.util.List;

/**
 * @author niuma
 * @create 2023-05-11 22:57
 */

public interface InnerOrderService {
    /**
     * 获取前 limit 购买数量的接口
     * @param limit
     * @return
     */
    List<Order> listTopBuyInterfaceInfo(int limit);
}
