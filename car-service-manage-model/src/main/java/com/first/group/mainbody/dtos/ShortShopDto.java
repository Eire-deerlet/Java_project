package com.first.group.mainbody.dtos;

import com.first.group.dtos.PageRequestDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class ShortShopDto extends PageRequestDto implements Serializable {
    private Integer id;         // 自增主键，汽修厂编码
    private String shortName;       // 简称
    private String contacts;        // 联系人
    private String contactNumber;   // 联系电话
    private Integer districtId;     // 所在区域id
    private Short chain;            // 是否连锁，0 否；1 是；
    private Short status;           // 锁定状态，0 正常；1 锁定；

    private Short type;             // 主体类型，1 汽修厂；2 配件商；3 其他
}
