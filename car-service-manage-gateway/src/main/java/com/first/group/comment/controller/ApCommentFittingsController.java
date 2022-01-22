package com.first.group.comment.controller;


import com.first.group.comment.dtos.CommentDto;
import com.first.group.comment.pojos.APFittingsComment;
import com.first.group.dtos.ResponseResult;
import com.first.group.comment.service.ApCommentFittingsService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("ap_commentFittings")

public class ApCommentFittingsController {

    @Reference
    private ApCommentFittingsService commentFittingsService;

    /**
     * 查看列表
     *
     * @param commentDto
     * @return
     */
    @GetMapping("/list")
    public ResponseResult<APFittingsComment> list(  CommentDto commentDto) {
        return commentFittingsService.list(commentDto);
    }

    /**
     * 删除评论
     *
     * @param commentDto
     * @return
     */
    @GetMapping("/delete")
    public ResponseResult delete(CommentDto commentDto) {
        return commentFittingsService.delete(commentDto);
    }


    /**
     *   查看当前评论
     * @param id
     * @return
     */
    @GetMapping("lookList")
    public ResponseResult lookList(@RequestParam  String id) {

      return commentFittingsService.lookList(id);
    }


    @PostMapping("insert")
    public void insert(@RequestBody APFittingsComment apFittingsComment) {
        commentFittingsService.insert(apFittingsComment);
    }

}
