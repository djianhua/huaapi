package com.niuma.huaapi.service;

import com.niuma.huaapiclientsdk.client.HuaApiClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author niuma
 * @create 2023-03-28 16:25
 */
@SpringBootTest
public class BinApiClientTest {

    @Test
    public void testRenjian(){
        HuaApiClient huaApiClient = new HuaApiClient("niuma","asdfg");
        String renjian = huaApiClient.renjian();
        System.out.println(renjian);

    }
}
