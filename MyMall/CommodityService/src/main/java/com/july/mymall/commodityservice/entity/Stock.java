package com.july.mymall.commodityservice.entity;

import lombok.Data;

import java.util.Date;

// 库存实体（独立表，支持分布式锁扣减）
@Data
public class Stock {
    private Long id;
    private Long productId;
    private Long specId;             // 规格ID（0表示无规格）
    private Integer quantity;        // 可用库存
    private Integer frozenQuantity;  // 冻结库存（订单占用）
    private Integer version;         // 版本号（乐观锁）
    private Date updateTime;
}
