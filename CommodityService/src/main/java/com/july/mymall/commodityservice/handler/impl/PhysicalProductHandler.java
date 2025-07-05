package com.july.mymall.commodityservice.handler.impl;

import com.july.mymall.commodityservice.handler.ProductTypeHandler;
import com.july.mymall.commodityservice.entity.Product;
import com.july.mymall.commodityservice.request.ProductCreateRequest;
import com.july.mymall.commodityservice.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 实物商品处理器
@Component
public class PhysicalProductHandler implements ProductTypeHandler {
    @Autowired
    private StockService stockService;

    @Override
    public void handleCreate(Product product, ProductCreateRequest request) {
        // 实物商品特殊处理（如物流信息校验）
    }

    @Override
    public boolean handleStockDeduct(Long productId, Long specId, Integer quantity) {
        // 调用库存服务正常扣减
        return stockService.deductStock(productId, specId, quantity);
    }

    @Override
    public int getProductType() {
        return 1; // 实物商品类型码
    }
}