package com.july.mymall.commodityservice.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

// 商品服务提供价格查询接口
public interface ProductPriceService {
    // 获取商品最终价格（含促销）
    BigDecimal getFinalPrice(Long productId, Long specId,
                             Long couponId, Integer quantity);
    // 批量获取商品价格
    Map<Long, Map<Long, BigDecimal>> batchGetFinalPrice(
            List<Long> productIds, List<Long> specIds, Long couponId);
}