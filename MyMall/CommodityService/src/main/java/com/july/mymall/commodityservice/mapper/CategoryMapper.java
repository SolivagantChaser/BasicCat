package com.july.mymall.commodityservice.mapper;

import com.july.mymall.commodityservice.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    List<Category> selectAll();

    Category selectById(long id);

    Category insert(Category category);

    Category update(Category category);

    int deleteById(long id);
}
