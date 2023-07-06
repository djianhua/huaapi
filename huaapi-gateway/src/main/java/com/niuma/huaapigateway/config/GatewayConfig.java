package com.niuma.huaapigateway.config;

import com.niuma.huaapigateway.filter.InterfaceFilter;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author niuma
 * @create 2023-05-03 21:28
 */
@Configuration
public class GatewayConfig {

    @Resource
    InterfaceFilter interfaceFilter;

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("huaapi-interface", r -> r.path("/api/interface/**")
                        .filters(f -> f.filter(interfaceFilter))
                        .uri("lb://huaapi-interface"))
                .build();
    }


}
