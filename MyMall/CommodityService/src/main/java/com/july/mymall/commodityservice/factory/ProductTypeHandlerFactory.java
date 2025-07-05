package com.july.mymall.commodityservice.factory;

import com.july.mymall.commodityservice.handler.impl.DefaultProductHandler;
import com.july.mymall.commodityservice.handler.ProductTypeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

// 策略工厂（根据商品类型选择处理器）
@Component
public class ProductTypeHandlerFactory {
    @Autowired
    private Map<String, ProductTypeHandler> handlers; // 自动注入所有实现类

    public ProductTypeHandler getHandler(String productType) {
        return handlers.getOrDefault(productType, new DefaultProductHandler());
    }
}
