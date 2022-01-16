package com.first.group.exception;

import com.first.group.dtos.ManagerCodeEnum;
import lombok.Getter;

/**
 * 自定义异常处理类
 */
@Getter
public class CarServiceException extends RuntimeException{
    private Integer code; // 状态码

    public CarServiceException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public CarServiceException(ManagerCodeEnum codeEnum) {
        super(codeEnum.getErrorMessage());
        this.code = codeEnum.getCode();
    }
}
