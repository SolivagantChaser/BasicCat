package com.july.mymall.commodityservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.july.mymall.commodityservice.mapper") // 指定 Mapper 包路径
public class CommodityServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommodityServiceApplication.class, args);
    }

}
