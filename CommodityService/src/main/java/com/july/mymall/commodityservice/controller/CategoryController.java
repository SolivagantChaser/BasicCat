package com.july.mymall.commodityservice.controller;

import com.july.mymall.commodityservice.common.Result;
import com.july.mymall.commodityservice.request.CategoryCreateRequest;
import com.july.mymall.commodityservice.response.CategoryDetailResponse;
import com.july.mymall.commodityservice.response.CategoryDetailsResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    // 查询分类树
    @GetMapping("/tree")
    public Result<CategoryDetailsResponse> getCategoryTree() {
        return Result.success(null);
    }

    // 查询分类详情
    @GetMapping("/{categoryId}")
    public Result<CategoryDetailResponse> getCategoryDetail(@PathVariable Long categoryId) {
        return Result.success(null);
    }

    // 新增分类
    @PostMapping
    public Result<Long> createCategory(@RequestBody CategoryCreateRequest categoryCreateRequest){
        return Result.success(null);
    }
}
