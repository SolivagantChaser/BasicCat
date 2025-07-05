package com.july.mymall.commodityservice.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Product {
    private Long id;                 // 商品ID
    private String name;             // 商品名称
    private String subTitle;          // 副标题
    private String description;       // 详细描述
    private Long categoryId;         // 分类ID
    private BigDecimal originalPrice; // 原价（用于促销对比）
    private BigDecimal currentPrice;  // 当前售价
    private Integer stock;           // 总库存
    private Integer sales;           // 累计销量
    private Integer sort;            // 排序权重
    private Integer status;          // 状态（1-上架，2-下架，3-删除）
    private String images;           // 主图URL（JSON数组）
    private String gallery;           // 轮播图URL（JSON数组）
    private Date createTime;
    private Date updateTime;

    // 扩展字段（支持不同商品类型）
    private Integer productType;     // 商品类型（1-实物，2-虚拟，3-服务）
    private String extraInfo;        // 扩展信息（JSON格式，如虚拟商品的卡密规则）
}
