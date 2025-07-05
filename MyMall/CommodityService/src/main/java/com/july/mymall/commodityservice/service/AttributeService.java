package com.july.mymall.commodityservice.service;

import com.july.mymall.commodityservice.dto.dto.AttributeDTO;
import com.july.mymall.commodityservice.entity.Attribute;

import java.util.List;
import java.util.Map;

// 属性服务接口
public interface AttributeService {
    // 获取分类关联的属性
    List<AttributeDTO> getAttributesByCategoryId(Long categoryId);
    // 保存分类属性
    void saveCategoryAttributes(Long categoryId, List<Attribute> attributes);
    // 校验商品属性是否合法
    boolean validateProductAttributes(Long categoryId, Map<String, Object> attributes);
}
