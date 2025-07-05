package com.july.mymall.commodityservice.handler.impl;

import com.july.mymall.commodityservice.entity.Product;
import com.july.mymall.commodityservice.request.ProductCreateRequest;
import com.july.mymall.commodityservice.handler.ProductTypeHandler;
import org.springframework.stereotype.Component;

import java.util.UUID;

// 虚拟商品处理器
@Component
public class VirtualProductHandler implements ProductTypeHandler {
    @Override
    public void handleCreate(Product product, ProductCreateRequest request) {
        // 虚拟商品特殊处理（如卡密生成）
        String cardNo = generateCardNo();
        product.setExtraInfo(cardNo);
    }

    private String generateCardNo() {

        return UUID.randomUUID().toString();
    }

    @Override
    public boolean handleStockDeduct(Long productId, Long specId, Integer quantity) {
        // 虚拟商品库存扣减逻辑（可能不需要真实库存，直接生成卡密）
        generateVirtualGoods(quantity);
        return true;
    }

    private void generateVirtualGoods(Integer quantity) {

    }

    @Override
    public int getProductType() {
        return 2; // 虚拟商品类型码
    }
}