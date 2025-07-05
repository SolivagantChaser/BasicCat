package com.july.mymall.commodityservice.entity;

import lombok.Data;

// 动态属性表设计
@Data
public class ProductDynamicAttr {
    private Long id;
    private Long productId;
    private String attrName;
    private String attrValue;
    private String attrType; // 类型（text/number/json）
}
