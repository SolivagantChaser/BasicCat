package com.july.mymall.commodityservice.service;

import com.july.mymall.commodityservice.dto.AttributeDTO;
import com.july.mymall.commodityservice.entity.Attribute;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

// 属性服务接口
public interface AttributeService {
    // 获取分类关联的属性
    @Async("asyncExecutor")
    CompletableFuture<List<AttributeDTO>> getAttributesByCategoryId(Long categoryId);
    // 保存分类属性
    CompletableFuture<Void> saveCategoryAttributes(Long categoryId, List<Attribute> attributes);
    // 校验商品属性是否合法
    CompletableFuture<Boolean> validateProductAttributes(Long categoryId, Map<String, Object> attributes);
}
