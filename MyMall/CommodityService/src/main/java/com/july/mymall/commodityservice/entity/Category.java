package com.july.mymall.commodityservice.entity;

import lombok.Data;

// 分类实体（支持多级树状结构）
@Data
public class Category {
    private Long id;
    private String name;
    private Long parentId;
    private Integer level;
    private String icon;
    private Integer sort;
    private Boolean isShow;

    // 分类关联的属性组（冗余存储，提升查询效率）
    private String attributeIds;    // 关联属性ID列表（JSON数组）
}
