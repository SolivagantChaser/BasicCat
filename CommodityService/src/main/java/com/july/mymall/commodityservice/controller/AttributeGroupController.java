package com.july.mymall.commodityservice.controller;

import com.july.mymall.commodityservice.common.Result;
import com.july.mymall.commodityservice.response.AttributeDetailResponse;
import com.july.mymall.commodityservice.service.AttributeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/attribute")
public class AttributeGroupController {
    private final AttributeService attributeService;

    public AttributeGroupController(AttributeService attributeService) {
        this.attributeService = attributeService;
    }


    // 获取分类下的属性组列表
    @GetMapping("/category/{categoryId}")
    public CompletableFuture<Result<AttributeDetailResponse>> listByCategory(@PathVariable Long categoryId) {
        return attributeService.getAttributesByCategoryId(categoryId)
                .thenApply(attributeDTOS -> {
                    AttributeDetailResponse response = new AttributeDetailResponse();
                    response.setAttributes(attributeDTOS);
                    return Result.success(response);
                });

    }
}
