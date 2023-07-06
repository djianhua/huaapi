package com.niuma.huaapi.service.impl;

import com.niuma.huaapi.service.InterfaceInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author niumazlb
 * @create 2022-11-16 14:09
 */
@SpringBootTest
class InterfaceInfoServiceImplTest {

    @Resource
    InterfaceInfoService interfaceInfoService;
    @Test
    void shangxianjiekou() {

        Boolean shangxianjiekou = interfaceInfoService.onlineInterfaceInfo(22);
        System.out.println(shangxianjiekou);
    }

}