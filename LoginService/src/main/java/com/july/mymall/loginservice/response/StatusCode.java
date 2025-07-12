package com.july.mymall.loginservice.response;

/**
 * 统一状态码定义
 * 规则：
 * 200-299：成功
 * 400-499：客户端错误（参数、权限等）
 * 500-599：服务器错误
 * 1000+：业务自定义错误
 */
public class StatusCode {
    // 成功
    public static final int SUCCESS = 200;
    // 操作成功但无数据
    public static final int NO_CONTENT = 204;

    // 客户端错误
    public static final int PARAMETER_ERROR = 400;      // 参数错误
    public static final int UNAUTHORIZED = 401;         // 未授权
    public static final int FORBIDDEN = 403;            // 禁止访问
    public static final int NOT_FOUND = 404;            // 资源不存在

    // 服务器错误
    public static final int INTERNAL_SERVER_ERROR = 500; // 服务器内部错误
    public static final int SERVICE_UNAVAILABLE = 503;  // 服务不可用

    // 业务自定义错误（1000+）
    public static final int BUSINESS_ERROR = 1000;       // 业务逻辑错误
    public static final int STOCK_INSUFFICIENT = 1001;   // 库存不足
    public static final int COMMODITY_OFF_SHELF = 1002;  // 商品已下架
    public static final int DUPLICATE_OPERATION = 1003;  // 重复操作
}
