package com.july.mymall.commodityservice.service;

import com.july.mymall.commodityservice.dto.FilterParams;
import com.july.mymall.commodityservice.dto.ProductSearchDTO;
import com.july.mymall.commodityservice.dto.SearchParams;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SearchService {
    // 构建商品索引
    void buildProductIndex(Long productId);
    void batchBuildProductIndex(List<Long> productIds);
    // 搜索商品
    Page<ProductSearchDTO> searchProducts(String keyword, SearchParams params);
    // 过滤搜索（按分类、价格、属性等）
    Page<ProductSearchDTO> filterProducts(FilterParams params);
}
