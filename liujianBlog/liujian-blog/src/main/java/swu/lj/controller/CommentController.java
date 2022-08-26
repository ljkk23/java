package swu.lj.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
@Api(tags = "评论",description = "评论相关接口")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @GetMapping("/commentList")
    @ApiImplicitParams({
            @ApiImplicitParam(name ="articleId",value = "文章的标识ID"),
            @ApiImplicitParam(name = "pageNum",value = "页号"),
            @ApiImplicitParam(name = "pageSize",value = "每一页的大小 "),
    }
    )
    public ResponseResult getCommentList(Long articleId,Integer pageNum,Integer pageSize){
       return commentService.getCommentlist(articleId,pageNum,pageSize);
    }


}

