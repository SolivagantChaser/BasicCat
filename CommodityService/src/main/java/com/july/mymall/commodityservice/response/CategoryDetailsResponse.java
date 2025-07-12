package com.july.mymall.commodityservice.response;

import com.july.mymall.commodityservice.dto.CategoryDetail;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDetailsResponse {
    private List<CategoryDetail> categoryDetails;

    private int total;
}
