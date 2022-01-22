package com.first.group.exception;


import com.first.group.dtos.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 拦截并处理异常
 * 由于springMVC会自动处理异常并返回异常信息，但是返回信息格式与前端响应要求不符
 * 所以需对异常信息进行拦截，处理成前端需要的信息格式再返回
 */
@RestControllerAdvice //标记用于处理controller异常
public class GlobalExceptionHandler {

    @ExceptionHandler(value = LeadNewsException.class) //处理业务异常
    public ResponseResult leadNewsExceptionHandler(LeadNewsException e){
        return ResponseResult.errorResult(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)//处理系统异常
    public ResponseResult exceptionHandler(Exception e){
        return ResponseResult.errorResult(500, "服务异常："+e.getMessage());
    }
}
