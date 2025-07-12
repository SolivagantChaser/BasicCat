package com.july.mymall.commodityservice.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AttributeDTO {
    // 类型id
    private int categoryId;
    // 名称
    private String name;
    // 类型
    private String valueType;
    // 可选值
    private String options;
    // 是否必选
    private boolean isRequired;
    // 是否可搜索
    private boolean isSearchable;
    // 是否可过滤
    private Boolean isFilterable;
    // 创建时间
    private Date createTime;
    // 更新时间
    private Date updateTime;
}
