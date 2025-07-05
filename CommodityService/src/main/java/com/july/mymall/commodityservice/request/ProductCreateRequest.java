package com.july.mymall.commodityservice.request;

import com.july.mymall.commodityservice.dto.dto.Specifications;
import com.july.mymall.commodityservice.entity.Product;
import lombok.Data;

import java.util.List;

@Data
public class ProductCreateRequest {
    // 规格
    List<Specifications> specs;

    public Product toEntity() {
        Product product = new Product();
        return product;
    }
}
