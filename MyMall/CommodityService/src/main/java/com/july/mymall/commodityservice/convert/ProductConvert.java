package com.july.mymall.commodityservice.convert;

import com.july.mymall.commodityservice.dto.dto.ProductDTO;
import com.july.mymall.commodityservice.entity.Product;

public class ProductConvert {
    public static ProductDTO toDTO(Product product) {

        return new ProductDTO();
    }
}
