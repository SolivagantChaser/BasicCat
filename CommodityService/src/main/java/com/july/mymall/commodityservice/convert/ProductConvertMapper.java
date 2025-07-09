package com.july.mymall.commodityservice.convert;

import com.july.mymall.commodityservice.dto.ProductDTO;
import com.july.mymall.commodityservice.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductConvertMapper {
    ProductConvertMapper INSTANCE = Mappers.getMapper(ProductConvertMapper.class);

    ProductDTO toDto(Product product);

    Product toProduct(ProductDTO productDTO);
}
