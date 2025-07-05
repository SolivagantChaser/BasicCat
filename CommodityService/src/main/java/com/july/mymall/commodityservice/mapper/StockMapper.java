package com.july.mymall.commodityservice.mapper;

import com.july.mymall.commodityservice.entity.Stock;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StockMapper {
    Stock getByProductAndSpec(Long productId, Long specId);

    int updateStockWithVersion(Stock updateStock);
}
