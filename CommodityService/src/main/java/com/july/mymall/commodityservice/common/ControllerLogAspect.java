package com.july.mymall.commodityservice.common;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.concurrent.CompletableFuture;

@Aspect
@Component
public class ControllerLogAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // 定义切点：匹配所有 Controller 包下的方法
    @Pointcut("execution(* com.july.mymall.commodityservice.controller.*.*(..))")
    public void controllerPointcut() {}

    // 前置通知：在方法执行前打印请求信息
    @Before("controllerPointcut()")
    public void beforeAdvice(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            // 打印请求信息
            logger.info("=============== 请求开始 ===============");
            logger.info("请求地址: {}", request.getRequestURL().toString());
            logger.info("请求方式: {}", request.getMethod());
            logger.info("请求类方法: {}", joinPoint.getSignature());
            logger.info("请求参数: {}", JSON.toJSONString(joinPoint.getArgs()));
        }
    }

    @AfterReturning(pointcut = "controllerPointcut()", returning = "result")
    public void afterReturningAdvice(Object result) {
        if (result instanceof CompletableFuture) {
            ((CompletableFuture<?>) result).whenComplete((res, ex) -> {
                logger.info("异步返回结果: {}", res);
            });
        } else {
            logger.info("同步返回结果: {}", result);
        }
    }

    // 异常通知：在方法抛出异常时打印异常信息
    @AfterThrowing(pointcut = "controllerPointcut()", throwing = "exception")
    public void afterThrowingAdvice(Exception exception) {
        logger.error("异常信息: {}", exception.getMessage(), exception);
        logger.info("=============== 请求异常结束 ===============");
    }

    @Around("controllerPointcut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();  // 执行目标方法
        long endTime = System.currentTimeMillis();
        logger.info("方法执行时间: {}ms", endTime - startTime);
        return result;
    }
}
