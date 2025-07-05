package com.july.mymall.commodityservice.service.impl;

import com.july.mymall.commodityservice.dto.dto.FilterParams;
import com.july.mymall.commodityservice.dto.dto.ProductSearchDTO;
import com.july.mymall.commodityservice.dto.dto.SearchParams;
import com.july.mymall.commodityservice.service.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Override
    public void buildProductIndex(Long productId) {

    }

    @Override
    public void batchBuildProductIndex(List<Long> productIds) {

    }

    @Override
    public Page<ProductSearchDTO> searchProducts(String keyword, SearchParams params) {
        return null;
    }

    @Override
    public Page<ProductSearchDTO> filterProducts(FilterParams params) {
        return null;
    }
}
