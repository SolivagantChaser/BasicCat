package com.july.mymall.commodityservice.request;

import com.july.mymall.commodityservice.dto.Specification;
import com.july.mymall.commodityservice.entity.Product;
import lombok.Data;

import java.util.List;

@Data
public class ProductCreateRequest {
    // 规格
    List<Specification> specs;

    public Product toEntity() {
        Product product = new Product();
        return product;
    }
}
