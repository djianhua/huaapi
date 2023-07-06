package com.niuma.huaapiclientsdk;

import com.niuma.huaapiclientsdk.client.HuaApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author niumadjh
 * @create 2022-11-09 20:38
 */
@Configuration
@ConfigurationProperties("huaapi-client")
@Data
@ComponentScan
public class HuaApiClientConfig {


    private String accessKey;
    private String secretKey;

    @Bean
    public HuaApiClient binApiClient(){
        HuaApiClient huaApiClient = new HuaApiClient(accessKey,secretKey);
        return huaApiClient;
    }

}
