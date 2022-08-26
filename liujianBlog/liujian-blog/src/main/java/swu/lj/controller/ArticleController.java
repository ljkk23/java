package swu.lj.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import swu.lj.domain.ResponseResult;
import swu.lj.service.IArticleService;


/**
 * <p>
 * 文章表 前端控制器
 * </p>
 *
 * @author liujian
 * @since 2022-05-20
 */
@RestController
@RequestMapping("/article")
@Api(tags = "文章",description = "文章相关接口")
public class ArticleController {
    @Autowired
    private IArticleService articleService;

    @ApiOperation(value = "热门文章",notes = "获取热门文章")
    @GetMapping("/hotArticleList")
    public ResponseResult hotArticleList(){
        return articleService.getHotArticleList();
    }

    @GetMapping("/articleList")
    public ResponseResult articleList(Integer pageNum,Integer pageSize,Long categoryID){
        return articleService.getArticleList(pageNum,pageSize,categoryID);
    }
    @GetMapping("/{id}")
    public ResponseResult getArticleDetails(@PathVariable("id") long id){
        return articleService.getArticleDetails(id);
    }
    @PutMapping("/updateViewCount/{id}")
    public ResponseResult updateViewCount(@PathVariable("id") Long id){
        return articleService.updateViewCount(id);
    }
}

