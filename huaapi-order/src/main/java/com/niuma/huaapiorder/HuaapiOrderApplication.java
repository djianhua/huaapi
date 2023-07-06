package com.niuma.huaapiorder;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.niuma")
@EnableDubbo
@MapperScan("com.niuma.huaapiorder.mapper")
public class HuaapiOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(HuaapiOrderApplication.class, args);
    }

}
