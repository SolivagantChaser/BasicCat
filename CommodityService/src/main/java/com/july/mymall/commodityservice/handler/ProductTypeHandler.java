package com.july.mymall.commodityservice.handler;

import com.july.mymall.commodityservice.entity.Product;
import com.july.mymall.commodityservice.request.ProductCreateRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// 商品类型处理器接口(策略模式)
public interface ProductTypeHandler {
    // 处理商品创建时的特殊逻辑
    void handleCreate(Product product, ProductCreateRequest request);
    // 处理库存扣减时的特殊逻辑
    boolean handleStockDeduct(Long productId, Long specId, Integer quantity);
    // 获取商品类型
    int getProductType();
}
