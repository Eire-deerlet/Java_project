package com.first.group.comment.impl;


import com.first.group.comment.pojo.CommentDto;
import com.first.group.comment.pojo.ApComment;
import com.first.group.dtos.ManagerCodeEnum;
import com.first.group.dtos.ResponseResult;
import com.first.group.comment.service.ApCommentService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

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

        List<ApComment> apComments = mongoTemplate.find(query, ApComment.class);


        return ResponseResult.okResult(apComments);
    }

    @Override
    public ResponseResult delete(CommentDto commentDto) {

        if (commentDto.getId() == null) {
            return ResponseResult.errorResult(ManagerCodeEnum.PARAM_INVALID);
        }

        mongoTemplate.remove(Query.query(Criteria.where("Id").is(commentDto.getId())), ApComment.class);


        return ResponseResult.okResult(ManagerCodeEnum.SUCCESS);
    }

    @Override
    public void insert(ApComment apComment) {
            mongoTemplate.insert(apComment);
    }
}
