package com.niuma.huaapithirdparty;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author niumazlb
 */
@SpringBootApplication(scanBasePackages = "com.niuma")
@MapperScan("com.niuma.huaapithirdparty.mapper")
public class HuaapiThirdPartyApplication {

    public static void main(String[] args) {
        SpringApplication.run(HuaapiThirdPartyApplication.class, args);
    }

}
