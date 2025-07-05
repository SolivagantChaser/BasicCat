package com.july.mymall.commodityservice.mapper;

import com.july.mymall.commodityservice.entity.ProductDynamicAttr;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDynamicAttrMapper {
    ProductDynamicAttr selectById(long id);

    ProductDynamicAttr selectByProductId(long productId);

    ProductDynamicAttr insert(ProductDynamicAttr productDynamicAttr);

    int update(ProductDynamicAttr productDynamicAttr);

    int deleteById(long id);

    int deleteByProductId(long productId);
}
