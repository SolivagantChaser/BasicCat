package com.july.mymall.commodityservice.mapper;

import com.july.mymall.commodityservice.entity.Attribute;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AttributeMapper {

     List<Attribute> getByCategoryId(Long categoryId);
}
