package com.july.mymall.commodityservice.service;

// 服务层封装动态属性操作
public interface DynamicAttributeService {
    // 保存动态属性
    void saveDynamicAttribute(Long productId, String attrName,
                              Object attrValue, String attrType);
    // 获取动态属性
    <T> T getDynamicAttribute(Long productId, String attrName, Class<T> clazz);
    // 删除动态属性
    void deleteDynamicAttribute(Long productId, String attrName);
}
