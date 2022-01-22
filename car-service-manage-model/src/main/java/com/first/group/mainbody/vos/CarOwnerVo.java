package com.first.group.mainbody.vos;

import lombok.Data;

import java.io.Serializable;

@Data
public class CarOwnerVo implements Serializable {
    private String name;        // 车主名称
    private String phoneNumber; // 车主号码
    private Integer status;     // 锁定状态，0 正常；1 锁定；
}
