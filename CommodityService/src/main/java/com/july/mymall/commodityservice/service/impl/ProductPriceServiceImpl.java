package com.july.mymall.commodityservice.service.impl;

import com.july.mymall.commodityservice.mapper.ProductMapper;
import com.july.mymall.commodityservice.mapper.ProductSpecMapper;
import com.july.mymall.commodityservice.dto.PromotionPriceResult;
import com.july.mymall.commodityservice.entity.ProductSpec;
import com.july.mymall.commodityservice.request.PromotionPriceRequest;
import com.july.mymall.commodityservice.service.ProductPriceService;
import com.july.mymall.commodityservice.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

// 实现类（委托促销服务计算优惠）
@Service
public class ProductPriceServiceImpl implements ProductPriceService {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductSpecMapper productSpecMapper;
    @Autowired
    private PromotionService promotionService; // 促销服务接口

    @Override
    public BigDecimal getFinalPrice(Long productId, Long specId,
                                    Long couponId, Integer quantity) {
        // 1. 获取商品基础价格
        ProductSpec spec = productSpecMapper.getByProductAndSpec(productId, specId);
        BigDecimal basePrice = spec != null ? spec.getPrice() : productMapper.getById(productId).getCurrentPrice();

        // 2. 调用促销服务计算优惠
        PromotionPriceRequest request = new PromotionPriceRequest();
        request.setProductId(productId);
        request.setSpecId(specId);
        request.setBasePrice(basePrice);
        request.setQuantity(quantity);
        request.setCouponId(couponId);

        PromotionPriceResult result = promotionService.calculatePrice(request);
        return result.getFinalPrice();
    }

    @Override
    public Map<Long, Map<Long, BigDecimal>> batchGetFinalPrice(List<Long> productIds, List<Long> specIds, Long couponId) {
        return null;
    }
}
