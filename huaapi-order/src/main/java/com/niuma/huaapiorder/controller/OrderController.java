package com.niuma.huaapiorder.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.niuma.huaapicommon.common.BaseResponse;
import com.niuma.huaapicommon.common.ResultUtils;
import com.niuma.huaapiorder.model.dto.OrderAddRequest;
import com.niuma.huaapiorder.model.dto.OrderQueryRequest;
import com.niuma.huaapicommon.model.vo.OrderVO;
import com.niuma.huaapiorder.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author niuma
 * @create 2023-05-03 15:53
 */
@RestController
@RequestMapping("/")
public class OrderController {

    @Resource
    OrderService orderService;

    @PostMapping("/addOrder")
    public BaseResponse<OrderVO> addOrder(@RequestBody OrderAddRequest addOrderRequest, HttpServletRequest request) {
        OrderVO orderVO = orderService.addOrder(addOrderRequest, request);
        return ResultUtils.success(orderVO);
    }

    @GetMapping("/list")
    public BaseResponse<Page<OrderVO>> listPageOrder(OrderQueryRequest orderQueryRequest, HttpServletRequest request){
        Page<OrderVO> orderPage = orderService.listPageOrder(orderQueryRequest, request);
        return ResultUtils.success(orderPage);
    }
}
