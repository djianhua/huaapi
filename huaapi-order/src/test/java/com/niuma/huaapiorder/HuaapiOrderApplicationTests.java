package com.niuma.huaapiorder;

import com.niuma.huaapiorder.mapper.OrderMapper;
import com.niuma.huaapicommon.model.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class HuaapiOrderApplicationTests {

    @Resource
    OrderMapper orderMapper;
    @Test
    void contextLoads() {
        List<Order> orders = orderMapper.listTopBuyInterfaceInfo(3);
        System.out.println(orders);
    }

}
