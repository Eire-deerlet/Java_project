package com.first.group.exception;


import com.first.group.dtos.ManagerCodeEnum;
import lombok.Getter;

/**
 * 自定义业务异常类，用于封装业务异常
 */
@Getter //用于获取异常信息
public class LeadNewsException extends RuntimeException {

    private Integer code;

    //父类中已定义异常信息message，无需再定义，继承后可直接用
    public LeadNewsException(Integer code,String message){
        super(message);
        this.code = code;
    }

    public LeadNewsException(ManagerCodeEnum appHttpCodeEnum){
        super(appHttpCodeEnum.getErrorMessage());
        this.code = appHttpCodeEnum.getCode();
    }
}
