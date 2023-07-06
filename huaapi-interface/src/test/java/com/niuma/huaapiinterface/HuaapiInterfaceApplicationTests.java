package com.niuma.huaapiinterface;

import com.niuma.huaapiclientsdk.client.HuaApiClient;
import com.niuma.huaapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class HuaapiInterfaceApplicationTests {
    @Resource
    private HuaApiClient huaApiClient;

    @Test
    void contextLoads() {
        User user = new User();
        user.setUsername("niuma");
        String userByPost = huaApiClient.getUserByPost(user);
        System.out.println(userByPost);

    }

}
