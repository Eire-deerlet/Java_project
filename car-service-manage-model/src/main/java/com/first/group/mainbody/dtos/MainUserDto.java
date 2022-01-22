package com.first.group.mainbody.dtos;

import com.first.group.dtos.PageRequestDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class MainUserDto extends PageRequestDto implements Serializable {
    private Integer bodyId; //  主体id
    private String username;    //  用户名
    private String name;    //  姓名
    private String password;    //  密码
    private String phoneNumber; //  手机

}
