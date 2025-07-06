package com.july.mymall.commodityservice.controller;

import com.july.mymall.commodityservice.common.Result;
import com.july.mymall.commodityservice.request.ProductCreateRequest;
import com.july.mymall.commodityservice.request.ProductQueryParams;
import com.july.mymall.commodityservice.request.ProductUpdateRequest;
import com.july.mymall.commodityservice.response.ProductDetailResponse;
import com.july.mymall.commodityservice.response.ProductDetailsResponse;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/commodities")
public class CommodityController {

    // 查询商品列表（支持分页、筛选、排序）
    @GetMapping
    public Result<ProductDetailsResponse> getCommodityList(ProductQueryParams productQueryParams) {
        return Result.success(null);
    }

    // 查询商品详情
    @GetMapping("/{commodityId}")
    public Result<ProductDetailResponse> getCommodityDetail(@PathVariable Long commodityId){
        return Result.success(null);
    }

    // 新增商品（需权限控制）
    @PostMapping
    public Result<Long> createCommodity(@RequestBody ProductCreateRequest productCreateRequest){
        return Result.success(null);
    }

    // 更新商品（需权限控制）
    @PutMapping("/{commodityId}")
    public Result<Void> updateCommodity(@RequestBody ProductUpdateRequest productUpdateRequest){
        return Result.success(null);
    }

    // 删除商品（需权限控制，支持逻辑删除）
    @DeleteMapping("/{commodityId}")
    public Result<Void> deleteCommodity(@PathVariable Long commodityId){
        return Result.success(null);
    }
}
