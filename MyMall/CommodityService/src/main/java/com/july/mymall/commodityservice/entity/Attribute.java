package com.july.mymall.commodityservice.entity;

import lombok.Data;

// 商品属性（支持动态配置）
@Data
public class Attribute {
    private Long id;
    private Long categoryId;         // 所属分类ID
    private String name;             // 属性名称
    private String valueType;        // 类型（text-文本/number-数字/select-单选/multi-多选）
    private String options;          // 可选值（JSON格式，如{"颜色":["红","蓝"]}）
    private Boolean isRequired;      // 是否必填
    private Boolean isSearchable;    // 是否可搜索
    private Integer sort;            // 排序
}