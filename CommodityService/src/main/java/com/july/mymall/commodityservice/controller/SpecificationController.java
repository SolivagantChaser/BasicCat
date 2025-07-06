package com.july.mymall.commodityservice.controller;

import com.july.mymall.commodityservice.common.Result;
import com.july.mymall.commodityservice.request.SpecificationCreateRequest;
import com.july.mymall.commodityservice.response.AttributeDetailsResponse;
import com.july.mymall.commodityservice.response.SpecificationDetailsResponse;
import com.july.mymall.commodityservice.service.AttributeService;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/specifications")
public class SpecificationController {
    private final AttributeService attributeService;

    public SpecificationController(AttributeService attributeService) {
        this.attributeService = attributeService;
    }
    // 查询商品规格（如颜色、尺寸）
    @GetMapping("/{commodityId}")
    public Result<SpecificationDetailsResponse> getSpecifications(@PathVariable Long commodityId) {
        return Result.success(null);
    }

    // 新增商品规格
    @PostMapping
    public Result<Void> createSpecification(@RequestBody SpecificationCreateRequest specificationCreateRequest) {
        return Result.success(null);
    }

    // 查询商品属性（如手机的屏幕尺寸、处理器）
    @GetMapping("/attributes/{commodityId}")
    public CompletableFuture<Result<AttributeDetailsResponse>> getAttributes(@PathVariable Long commodityId) {
        // todo commodityId -> categoryId
        long categoryId = commodityId;
        return attributeService.getAttributesByCategoryId(categoryId)
                .thenApply(attributeDTOS -> {
                    AttributeDetailsResponse response = AttributeDetailsResponse.builder().attributes(attributeDTOS).build();
                    return Result.success(response);
                });
    }
}
