package com.niuma.huaapi;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.niuma")
@MapperScan("com.niuma.huaapi.mapper")
@EnableDubbo
public class HuaapiBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(HuaapiBackendApplication.class, args);


    }

}
