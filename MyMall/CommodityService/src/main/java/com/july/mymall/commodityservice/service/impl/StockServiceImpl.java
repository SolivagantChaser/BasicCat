package com.july.mymall.commodityservice.service.impl;

import com.july.mymall.commodityservice.mapper.StockMapper;
import com.july.mymall.commodityservice.entity.Stock;
import com.july.mymall.commodityservice.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

// 分布式锁实现库存扣减
@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockMapper stockMapper;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private final String LOCK_PREFIX = "stock_lock:";
    private final long LOCK_TIMEOUT = 3000; // 3秒锁超时

    @Override
    public boolean deductStock(Long productId, Long specId, Integer quantity) {
        if (quantity <= 0) {
            return false;
        }

        // 1. 获取分布式锁（防止并发扣减）
        String lockKey = LOCK_PREFIX + productId + "_" + specId;
        String clientId = UUID.randomUUID().toString();
        boolean locked = false;
        try {
            locked = redisTemplate.opsForValue().setIfAbsent(
                    lockKey, clientId, LOCK_TIMEOUT, TimeUnit.MILLISECONDS);
            if (!locked) {
                return false; // 锁获取失败，说明有并发请求
            }

            // 2. 乐观锁更新库存
            Stock stock = stockMapper.getByProductAndSpec(productId, specId);
            if (stock == null || stock.getQuantity() < quantity) {
                return false; // 库存不足
            }

            Stock updateStock = new Stock();
            updateStock.setId(stock.getId());
            updateStock.setQuantity(stock.getQuantity() - quantity);
            updateStock.setFrozenQuantity(stock.getFrozenQuantity() + quantity);
            updateStock.setVersion(stock.getVersion());

            int affectedRows = stockMapper.updateStockWithVersion(updateStock);
            return affectedRows > 0;
        } finally {
            // 3. 释放锁（仅释放自己的锁）
            if (locked) {
                String storedClientId = redisTemplate.opsForValue().get(lockKey);
                if (clientId.equals(storedClientId)) {
                    redisTemplate.delete(lockKey);
                }
            }
        }
    }

    @Override
    public boolean releaseStock(Long productId, Long specId, Integer quantity) {
        return false;
    }

    @Override
    public boolean freezeStock(Long productId, Long specId, Integer quantity) {
        return false;
    }

    @Override
    public boolean batchDeductStock(Map<Long, Map<Long, Integer>> stockMap) {
        return false;
    }

    @Override
    public Integer getAvailableStock(Long productId, Long specId) {
        return null;
    }

    @Override
    public void initStock(Stock stock) {

    }
}
