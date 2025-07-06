package com.july.mymall.commodityservice.controller;

import com.july.mymall.commodityservice.common.Result;
import com.july.mymall.commodityservice.request.StockDeductRequest;
import com.july.mymall.commodityservice.request.StockRefundRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/stocks")
public class StockController {
    // 查询商品库存
    @GetMapping("/{commodityId}")
    public Result<Integer> getStock(@PathVariable Long commodityId) {
        return Result.success(null);
    }

    // 扣减库存（支持分布式锁防超卖）
    @PostMapping("/deduct")
    public Result<Boolean> deductStock(@RequestBody StockDeductRequest stockDeductRequest) {
        return Result.success(null);
    }

    // 回补库存（订单取消时调用）
    @PostMapping("/refund")
    public Result<Boolean> refundStock(@RequestBody StockRefundRequest stockRefundRequest){
        return Result.success(null);
    }

}
