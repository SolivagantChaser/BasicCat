package com.july.mymall.commodityservice.request;

import lombok.Data;

@Data
public class ProductQueryParams {
    private int page;
    private int size;
    private String categoryId;
    private String keyword;
    private String sortField;
}
