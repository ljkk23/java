package swu.lj.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import swu.lj.domain.ResponseResult;
import swu.lj.service.ICommentService;

/**
 * <p>
 * 评论表 前端控制器
 * </p>
 *
 * @author liujian
 * @since 2022-08-03
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @GetMapping("/commentList")
    public ResponseResult getCommentList(Long articleId,Integer pageNum,Integer pageSize){
       return commentService.getCommentlist(articleId,pageNum,pageSize);
    }


}

