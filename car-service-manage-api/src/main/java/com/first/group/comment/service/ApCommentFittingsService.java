package com.first.group.comment.service;

import com.first.group.comment.pojo.CommentDto;
import com.first.group.comment.pojo.APFittingsComment;
import com.first.group.dtos.ResponseResult;

public interface ApCommentFittingsService {
    ResponseResult<APFittingsComment> list(CommentDto commentDto);

    ResponseResult delete(CommentDto commentDto);

    void insert(APFittingsComment apFittingsComment);

    ResponseResult lookList(Integer id);
}
