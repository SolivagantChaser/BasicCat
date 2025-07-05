package com.july.mymall.commodityservice.service.impl;

import com.alibaba.fastjson2.JSON;
import com.july.mymall.commodityservice.convert.ProductConvert;
import com.july.mymall.commodityservice.mapper.ProductMapper;
import com.july.mymall.commodityservice.mapper.ProductSpecMapper;
import com.july.mymall.commodityservice.dto.dto.ProductDTO;
import com.july.mymall.commodityservice.dto.dto.ProductSpecDTO;
import com.july.mymall.commodityservice.entity.Product;
import com.july.mymall.commodityservice.entity.Stock;
import com.july.mymall.commodityservice.request.ProductCreateRequest;
import com.july.mymall.commodityservice.request.ProductQueryParams;
import com.july.mymall.commodityservice.request.ProductUpdateRequest;
import com.july.mymall.commodityservice.service.ProductService;
import com.july.mymall.commodityservice.service.SearchService;
import com.july.mymall.commodityservice.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

// 实现类关键方法示例
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductSpecMapper productSpecMapper;
    @Autowired
    private StockService stockService;
    @Autowired
    private SearchService searchService;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private final String CACHE_KEY = "product_list_page:";
    private final long CACHE_TTL = 3600; // 1小时缓存

    @Override
    @Transactional
    public ProductDTO createProduct(ProductCreateRequest request) {
        // 1. 保存商品主信息
        Product product = request.toEntity();
        productMapper.insert(product);
        Long productId = product.getId();

        // 2. 保存规格与库存
        request.getSpecs().forEach(spec -> {
            spec.setProductId(productId);
            productSpecMapper.insert(spec);
            // 规格库存初始化
            Stock stock = new Stock();
            stock.setProductId(productId);
            stock.setSpecId(spec.getId());
            stock.setQuantity(spec.getStock());
            stockService.initStock(stock);
        });

        // 3. 无规格商品默认库存
        if (request.getSpecs().isEmpty()) {
            Stock stock = new Stock();
            stock.setProductId(productId);
            stock.setQuantity(product.getStock());
            stockService.initStock(stock);
        }

        // 4. 异步构建搜索索引
        searchService.buildProductIndex(productId);

        return ProductConvert.toDTO(product);
    }

    @Override
    public void updateProduct(ProductUpdateRequest request) {

    }

    @Override
    public void deleteProduct(Long id) {

    }

    @Override
    public ProductDTO getProductById(Long id) {
        return null;
    }

    @Override
    public void publishProduct(Long id) {

    }

    @Override
    public void offlineProduct(Long id) {

    }

    @Override
    public List<ProductSpecDTO> getSpecsByProductId(Long productId) {
        return null;
    }

    @Override
    public void updateSpecStock(Long specId, Integer quantity) {

    }

    @Override
    public List<ProductDTO> batchGetProducts(List<Long> ids) {
        return null;
    }

    @Override
    public Map<Long, Integer> batchGetStock(List<Long> productIds, List<Long> specIds) {
        return null;
    }

    @Override
    public Page<ProductDTO> getProductPage(ProductQueryParams params) {
        // 生成缓存Key（包含查询参数）
        String cacheKey = CACHE_KEY + JSON.toJSONString(params);
        Page<ProductDTO> cachedResult = (Page<ProductDTO>) redisTemplate.opsForValue().get(cacheKey);

        if (cachedResult != null) {
            return cachedResult; // 命中缓存
        }

        // 未命中缓存，查询数据库
        Page<Product> productPage = productMapper.selectByParams(params);
        List<ProductDTO> dtos = productPage.getContent().stream()
                .map(ProductConvert::toDTO)
                .collect(Collectors.toList());

        // 封装分页结果
        Page<ProductDTO> result = new PageImpl<>(dtos,
                PageRequest.of(params.getPage() - 1, params.getSize()),
                productPage.getTotalElements());

        // 写入缓存（异步处理，避免影响响应时间）
        CompletableFuture.runAsync(() -> {
            redisTemplate.opsForValue().set(cacheKey, result, CACHE_TTL, TimeUnit.SECONDS);
        });

        return result;
    }
}
