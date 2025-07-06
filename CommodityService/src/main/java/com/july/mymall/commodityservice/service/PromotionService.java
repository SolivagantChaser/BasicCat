package com.july.mymall.commodityservice.service;

import com.july.mymall.commodityservice.dto.PromotionPriceResult;
import com.july.mymall.commodityservice.request.PromotionPriceRequest;

public interface PromotionService {
    PromotionPriceResult calculatePrice(PromotionPriceRequest request);
}
