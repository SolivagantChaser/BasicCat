package com.july.mymall.commodityservice.mapper;

import com.july.mymall.commodityservice.dto.dto.Specifications;
import com.july.mymall.commodityservice.entity.ProductSpec;
import org.apache.ibatis.annotations.Mapper;


/**
 * 商品规格表
 */
@Mapper
public interface ProductSpecMapper {
    ProductSpec getByProductAndSpec(Long productId, Long specId);

    void insert(Specifications spec);
}
