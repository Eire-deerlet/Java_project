package com.first.group.comment.controller;

import com.first.group.comment.dtos.CommentDto;
import com.first.group.comment.pojos.ApComment;
import com.first.group.dtos.ResponseResult;
import com.first.group.comment.service.ApCommentService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ap_comment")
public class ApCommentController {

    @Reference
    private ApCommentService apCommentService;

    /**
     * 查看列表
     *
     * @param commentDto
     * @return
     */
    @GetMapping("/list")
    public ResponseResult<List<ApComment>> list( CommentDto commentDto) {
        return apCommentService.list(commentDto);
    }

    @GetMapping("/delete")
    public ResponseResult delete(@RequestBody CommentDto commentDto) {
        return apCommentService.delete(commentDto);
    }


    @PostMapping("/insert")
    public void insert(@RequestBody ApComment apComment) {
        apCommentService.insert(apComment);
    }

    @GetMapping("looklist")
    public ResponseResult<ApComment> lookList(String id){
        return apCommentService.lookList(id);
    };
}
