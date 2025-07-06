package com.july.mymall.commodityservice.mapper;

import com.july.mymall.commodityservice.dto.Specification;
import com.july.mymall.commodityservice.entity.ProductSpec;
import org.apache.ibatis.annotations.Mapper;


/**
 * 商品规格表
 */
@Mapper
public interface ProductSpecMapper {
    ProductSpec getByProductAndSpec(Long productId, Long specId);

    void insert(Specification spec);
}
