package com.july.mymall.loginservice.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Objects;

/**
 * 统一接口返回结果封装类
 * @param <T> 数据类型
 */
@JsonInclude(JsonInclude.Include.NON_NULL) // 空字段不返回
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    // 状态码
    private Integer code;
    // 状态消息
    private String message;
    // 是否成功
    private Boolean success;
    // 响应数据
    private T data;

    // 构造函数
    private Result() {}

    private Result(Integer code, String message, Boolean success, T data) {
        this.code = code;
        this.message = message;
        this.success = success;
        this.data = data;
    }

    // 成功响应（带数据）
    public static <T> Result<T> success(T data) {
        return success("操作成功", data);
    }

    // 成功响应（带消息和数据）
    public static <T> Result<T> success(String message, T data) {
        return new Result<>(StatusCode.SUCCESS, message, true, data);
    }

    // 成功响应（仅消息）
    public static <T> Result<T> success(String message) {
        return new Result<>(StatusCode.SUCCESS, message, true, null);
    }

    // 失败响应（带状态码和消息）
    public static <T> Result<T> error(Integer code, String message) {
        return error(code, message, null);
    }

    // 失败响应（带状态码、消息和数据）
    public static <T> Result<T> error(Integer code, String message, T data) {
        return new Result<>(code, message, false, data);
    }

    // 业务异常响应（使用业务异常状态码）
    public static <T> Result<T> businessError(String message) {
        return error(StatusCode.BUSINESS_ERROR, message);
    }

    // 参数错误响应
    public static <T> Result<T> parameterError(String message) {
        return error(StatusCode.PARAMETER_ERROR, message);
    }

    // 未授权响应
    public static <T> Result<T> unauthorized(String message) {
        return error(StatusCode.UNAUTHORIZED, message);
    }

    // 服务器内部错误
    public static <T> Result<T> internalError(String message) {
        return error(StatusCode.INTERNAL_SERVER_ERROR, message);
    }

    // Getter & Setter
    public Integer getCode() { return code; }
    public void setCode(Integer code) { this.code = code; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public Boolean getSuccess() { return success; }
    public void setSuccess(Boolean success) { this.success = success; }
    public T getData() { return data; }
    public void setData(T data) { this.data = data; }

    // 便捷方法：判断是否成功
    public boolean isSuccess() {
        return success != null && success;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result<?> result = (Result<?>) o;
        return Objects.equals(code, result.code) &&
                Objects.equals(message, result.message) &&
                Objects.equals(success, result.success) &&
                Objects.equals(data, result.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message, success, data);
    }
}
