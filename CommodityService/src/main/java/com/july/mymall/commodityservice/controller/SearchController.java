package com.july.mymall.commodityservice.controller;

import com.july.mymall.commodityservice.common.Result;
import com.july.mymall.commodityservice.request.ProductSearchRequest;
import com.july.mymall.commodityservice.response.ProductSearchResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/search")
public class SearchController {
    // 全文搜索商品（集成Elasticsearch）
    @PostMapping
    public Result<ProductSearchResponse> searchCommodities(@RequestBody ProductSearchRequest productSearchRequest){
        return Result.success(null);
    }

    // 自动补全搜索词
    @GetMapping("/suggest")
    public Result<List<String>> suggestKeywords(@RequestParam String keyword){
        return Result.success(null);
    }
}
