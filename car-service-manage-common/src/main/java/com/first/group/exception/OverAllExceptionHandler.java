package com.first.group.exception;

import com.first.group.dtos.ManagerCodeEnum;
import com.first.group.dtos.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
@Slf4j
public class OverAllExceptionHandler {
    @ExceptionHandler(Exception.class)  // 指定需要处理的异常类型
    public ResponseResult exception(Exception e){
        log.error("系统异常：", e);
        return ResponseResult.errorResult(ManagerCodeEnum.SERVER_ERROR.getCode(), ManagerCodeEnum.SERVER_ERROR.getErrorMessage());
    }

    @ExceptionHandler(CarServiceException.class)  // 指定需要处理的异常类型
    public ResponseResult exception(CarServiceException csException){
        log.error("业务异常：", csException);
        return ResponseResult.errorResult(csException.getCode(), csException.getMessage());
    }
}
