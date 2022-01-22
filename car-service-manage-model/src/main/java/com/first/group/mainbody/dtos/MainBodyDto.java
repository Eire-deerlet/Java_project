package com.first.group.mainbody.dtos;

import com.first.group.dtos.PageRequestDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class MainBodyDto extends PageRequestDto implements Serializable {
    private Integer id;     //  自增主键,商户编码
    private String shortName;   //  简称
    private Short type;   //  主体类型
    private Short status;   //  锁定状态
    private Integer districtId; //  所属区域id
}
