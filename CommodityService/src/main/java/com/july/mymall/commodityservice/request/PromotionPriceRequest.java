package com.july.mymall.commodityservice.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PromotionPriceRequest {
    private Long productId;
    // 规格id
    private Long specId;
    // 优惠券id
    private Long couponId;
    // 数量
    private Integer quantity;
    // 基础价格
    private BigDecimal basePrice;
}
