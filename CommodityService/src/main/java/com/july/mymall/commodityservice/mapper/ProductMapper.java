package com.july.mymall.commodityservice.mapper;

import com.july.mymall.commodityservice.entity.Product;
import com.july.mymall.commodityservice.request.ProductQueryParams;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;

@Mapper
public interface ProductMapper {
    void insert(Product product);

    Page<Product> selectByParams(ProductQueryParams params);

    Product getById(Long productId);
}
