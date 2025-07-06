package com.july.mymall.commodityservice.service;

import com.july.mymall.commodityservice.dto.ProductDTO;
import com.july.mymall.commodityservice.dto.ProductSpecDTO;
import com.july.mymall.commodityservice.request.ProductCreateRequest;
import com.july.mymall.commodityservice.request.ProductQueryParams;
import com.july.mymall.commodityservice.request.ProductUpdateRequest;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface ProductService {
    // 商品CRUD
    ProductDTO createProduct(ProductCreateRequest request);
    void updateProduct(ProductUpdateRequest request);
    void deleteProduct(Long id);
    ProductDTO getProductById(Long id);
    Page<ProductDTO> getProductPage(ProductQueryParams params);

    // 上下架管理
    void publishProduct(Long id);
    void offlineProduct(Long id);

    // 规格管理
    List<ProductSpecDTO> getSpecsByProductId(Long productId);
    void updateSpecStock(Long specId, Integer quantity);

    // 与其他服务集成
    List<ProductDTO> batchGetProducts(List<Long> ids);
    Map<Long, Integer> batchGetStock(List<Long> productIds, List<Long> specIds);
}
