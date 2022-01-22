package com.first.group.comment.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommentDto implements Serializable {
    private String id;//  订单id
    private String serviceStore;//门店名称
    private String serviceClassify;//服务分类
    private String startTime;//开始时间
    private String endTime;//结束时间
    private Integer curPage;//当前页
    private Integer pageSize;//每页大少

}
