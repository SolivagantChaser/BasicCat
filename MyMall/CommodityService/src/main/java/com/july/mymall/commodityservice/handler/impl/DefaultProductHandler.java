package com.july.mymall.commodityservice.handler.impl;

import com.july.mymall.commodityservice.handler.ProductTypeHandler;
import com.july.mymall.commodityservice.entity.Product;
import com.july.mymall.commodityservice.request.ProductCreateRequest;
import org.springframework.stereotype.Component;

@Component
public class DefaultProductHandler implements ProductTypeHandler {

    @Override
    public void handleCreate(Product product, ProductCreateRequest request) {
        
    }

    @Override
    public boolean handleStockDeduct(Long productId, Long specId, Integer quantity) {
        return false;
    }

    @Override
    public int getProductType() {
        return 0;
    }
}
