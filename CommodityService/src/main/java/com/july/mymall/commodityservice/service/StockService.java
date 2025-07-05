package com.july.mymall.commodityservice.service;

import com.july.mymall.commodityservice.entity.Stock;

import java.util.Map;

public interface StockService {
    // 库存扣减（支持分布式锁）
    boolean deductStock(Long productId, Long specId, Integer quantity);
    // 库存释放
    boolean releaseStock(Long productId, Long specId, Integer quantity);
    // 库存冻结（订单预占）
    boolean freezeStock(Long productId, Long specId, Integer quantity);
    // 批量扣减（订单支付时）
    boolean batchDeductStock(Map<Long, Map<Long, Integer>> stockMap);
    // 查询库存
    Integer getAvailableStock(Long productId, Long specId);

    void initStock(Stock stock);
}
