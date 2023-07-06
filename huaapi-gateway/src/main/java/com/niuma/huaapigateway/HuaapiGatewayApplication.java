package com.niuma.huaapigateway;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author niumazlb
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class},scanBasePackages = "com.niuma")
@EnableDubbo
public class HuaapiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(HuaapiGatewayApplication.class, args);
    }

}
