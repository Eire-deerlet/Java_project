package com.first.group.comment.service;


import com.first.group.comment.dtos.CommentDto;
import com.first.group.comment.pojos.ApComment;
import com.first.group.dtos.ResponseResult;

import java.util.List;

public interface ApCommentService {
    ResponseResult<List<ApComment>> list(CommentDto commentDto);

    ResponseResult delete(CommentDto commentDto) ;

    void insert(ApComment apComment);
}
