package com.july.mymall.commodityservice.service.impl;

import com.alibaba.fastjson2.JSON;
import com.july.mymall.commodityservice.mapper.AttributeMapper;
import com.july.mymall.commodityservice.dto.AttributeDTO;
import com.july.mymall.commodityservice.entity.Attribute;
import com.july.mymall.commodityservice.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Service
public class AttributeServiceImpl implements AttributeService {
    @Autowired
    private AttributeMapper attributeMapper;
    @Override
    public CompletableFuture<List<AttributeDTO>> getAttributesByCategoryId(Long categoryId) {
        return null;
    }

    @Override
    public CompletableFuture<Void> saveCategoryAttributes(Long categoryId, List<Attribute> attributes) {
        return CompletableFuture.completedFuture(null);
    }

    // 实现类示例（属性校验逻辑）
    @Override
    public CompletableFuture<Boolean> validateProductAttributes(Long categoryId, Map<String, Object> attributes) {
        List<Attribute> categoryAttributes = attributeMapper.getByCategoryId(categoryId);
        if (categoryAttributes == null || categoryAttributes.isEmpty()) {
            return CompletableFuture.completedFuture(true); // 无属性时默认合法
        }

        for (Attribute attr : categoryAttributes) {
            if (attr.getIsRequired() && !attributes.containsKey(attr.getName())) {
                return CompletableFuture.completedFuture(false); // 缺少必填属性
            }

            Object value = attributes.get(attr.getName());
            if (value == null) {
                continue;
            }

            // 根据属性类型校验值（文本、数字、枚举等）
            if ("select".equals(attr.getValueType()) || "multi".equals(attr.getValueType())) {
                // 枚举值校验
                Set<String> validOptions = new HashSet<>(JSON.parseArray(attr.getOptions(), String.class));
                if ("select".equals(attr.getValueType()) && !validOptions.contains(value)) {
                    return CompletableFuture.completedFuture(false);
                }
                if ("multi".equals(attr.getValueType())) {
                    List<String> values = JSON.parseArray(value.toString(), String.class);
                    for (String v : values) {
                        if (!validOptions.contains(v)) {
                            return CompletableFuture.completedFuture(false);
                        }
                    }
                }
            } else if ("number".equals(attr.getValueType())) {
                // 数字格式校验
                try {
                    Double.parseDouble(value.toString());
                } catch (NumberFormatException e) {
                    return CompletableFuture.completedFuture(false);
                }
            }
            // 其他类型校验略...
        }
        return CompletableFuture.completedFuture(true);
    }
}
