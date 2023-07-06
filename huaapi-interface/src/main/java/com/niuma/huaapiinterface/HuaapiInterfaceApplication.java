package com.niuma.huaapiinterface;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.niuma.huaapiinterface.mapper")
public class HuaapiInterfaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HuaapiInterfaceApplication.class, args);
    }

}
