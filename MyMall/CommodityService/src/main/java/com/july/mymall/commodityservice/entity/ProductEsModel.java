package com.july.mymall.commodityservice.entity;

import com.alibaba.fastjson2.JSON;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Elasticsearch索引模型
@Data
public class ProductEsModel {
    private Long id;
    private String name;
    private String subTitle;
    private BigDecimal currentPrice;
    private String description;
    private Long categoryId;
    private String categoryName;
    private List<String> images;
    private Integer sales;
    private Integer stock;
    private String[] attributes; // 商品属性文本（用于全文搜索）
    private Map<String, Object> specValues; // 规格值（用于过滤）

    // 构建器模式初始化
    public static ProductEsModel buildFromProduct(Product product,
                                                  List<ProductSpec> specs,
                                                  Category category) {
        ProductEsModel esModel = new ProductEsModel();
        esModel.setId(product.getId());
        esModel.setName(product.getName());
        esModel.setSubTitle(product.getSubTitle());
        esModel.setCurrentPrice(product.getCurrentPrice());
        esModel.setDescription(product.getDescription());
        esModel.setCategoryId(product.getCategoryId());
        esModel.setCategoryName(category != null ? category.getName() : "");
        esModel.setImages(JSON.parseArray(product.getImages(), String.class));
        esModel.setSales(product.getSales());
        esModel.setStock(product.getStock());

        // 组装属性文本（用于搜索）
        List<String> attrTexts = new ArrayList<>();
        // 此处省略属性查询逻辑...
        esModel.setAttributes(attrTexts.toArray(new String[0]));

        // 组装规格值（用于过滤）
        Map<String, Object> specMap = new HashMap<>();
        specs.forEach(spec -> {
            specMap.put(spec.getId().toString(), JSON.parseObject(spec.getSpecValues()));
        });
        esModel.setSpecValues(specMap);

        return esModel;
    }
}
