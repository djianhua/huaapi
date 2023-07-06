package com.niuma.huaapiorder.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niuma.huaapiorder.model.entity.OrderLock;
import com.niuma.huaapiorder.service.OrderLockService;
import com.niuma.huaapiorder.mapper.OrderLockMapper;
import org.springframework.stereotype.Service;

/**
* @author niumazlb
* @description 针对表【order_lock】的数据库操作Service实现
* @createDate 2023-05-03 15:52:09
*/
@Service
public class OrderLockServiceImpl extends ServiceImpl<OrderLockMapper, OrderLock>
    implements OrderLockService{

}




