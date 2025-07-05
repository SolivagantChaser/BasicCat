package com.july.mymall.commodityservice.entity;

import lombok.Data;

import java.math.BigDecimal;

// 商品规格与库存（支持多规格组合）
@Data
public class ProductSpec {
    private Long id;
    private Long productId;
    private String specName;         // 规格名称（如"颜色+尺寸"）
    private String specValues;       // 规格值JSON（如{"颜色":"红色","尺寸":"L"}）
    private BigDecimal price;        // 规格价格
    private Integer stock;           // 规格库存
    private String images;           // 规格专属图片（JSON数组）
}
