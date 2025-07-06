package com.july.mymall.commodityservice.dto;

import lombok.Data;

@Data
public class Specification {
    private Long id;
    // 商品id
    private Long productId;
    // 库存
    private Integer stock;
}
