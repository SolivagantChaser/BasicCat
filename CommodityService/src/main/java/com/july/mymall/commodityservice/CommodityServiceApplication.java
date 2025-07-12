package com.july.mymall.commodityservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = "com.july.mymall.commodityservice")
@EnableAspectJAutoProxy  // 启用 AOP 自动代理
@EnableAsync
public class CommodityServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommodityServiceApplication.class, args);
    }

}
