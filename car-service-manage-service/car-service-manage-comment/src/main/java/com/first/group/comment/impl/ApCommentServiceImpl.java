package com.first.group.comment.impl;


import com.first.group.comment.BeanHelper;
import com.first.group.comment.dtos.*;

import com.first.group.comment.pojos.ApComment;
import com.first.group.comment.service.ApCommentService;
import com.first.group.dtos.ManagerCodeEnum;
import com.first.group.dtos.ResponseResult;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApCommentServiceImpl implements ApCommentService {
    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public ResponseResult<List<ApComment>> list(CommentDto commentDto) {


        if (commentDto.getCurPage() == null) {
            commentDto.setCurPage(1);
        }
        if (commentDto.getPageSize() == null) {
            commentDto.setPageSize(5);
        }
        //查询列表
        Query query = new Query();
        if (commentDto.getServiceClassify() != "" && commentDto.getServiceClassify() != null) {
            query.addCriteria(Criteria.where("service_classify").is(commentDto.getServiceClassify()));

        }
        if (commentDto.getServiceStore() != "" && commentDto.getServiceStore() != null) {
            query.addCriteria(Criteria.where("service_store").is(commentDto.getServiceStore()));
        }
        if (commentDto.getEndTime() != null && commentDto.getStartTime() != null) {
            query.addCriteria(Criteria.where("orderTime").gte(commentDto.getStartTime()).lt(commentDto.getEndTime()));
        }
        query.addCriteria(Criteria.where("status").is(0));
        query.limit(commentDto.getPageSize());


        List<ApComment> collect = mongoTemplate.find(query, ApComment.class).stream().map(apComment -> {

            ApComment comment = BeanHelper.copyProperties(apComment, ApComment.class);

            comment.setImage(Collections.singletonList(apComment.getImage()).stream().collect(Collectors.joining(",")));
            return comment;

        }).collect(Collectors.toList());

        return ResponseResult.okResult(collect);
    }

    private volatile boolean flag = false;

    @Override
    public ResponseResult delete(CommentDto commentDto) {

        if (commentDto.getId() == null) {
            return ResponseResult.errorResult(ManagerCodeEnum.PARAM_INVALID);
        }
        synchronized (this) {
            if (!flag) {

                mongoTemplate.remove(Query.query(Criteria.where("Id").is(commentDto.getId())), ApComment.class);
                flag = true;
            }
        }
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    @Override
    public void insert(ApComment apComment) {
        mongoTemplate.insert(apComment);

    }

    @Override
    public ResponseResult<ApComment> lookList(String id) {


        return ResponseResult.okResult(mongoTemplate.findById(id, ApComment.class));
    }
}
