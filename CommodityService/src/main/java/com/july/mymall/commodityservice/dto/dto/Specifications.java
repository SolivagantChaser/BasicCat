package com.july.mymall.commodityservice.dto.dto;

import lombok.Data;

@Data
public class Specifications {
    private Long id;
    // 商品id
    private Long productId;
    // 库存
    private Integer stock;
}
