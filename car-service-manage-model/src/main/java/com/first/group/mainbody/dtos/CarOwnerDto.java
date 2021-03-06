package com.first.group.mainbody.dtos;

import com.first.group.dtos.PageRequestDto;
import lombok.Data;

@Data
public class CarOwnerDto extends PageRequestDto {
    private String name;    // 车主名称
    private String phoneNumber; // 车主手机号
    private Integer status; // 锁定状态
}
