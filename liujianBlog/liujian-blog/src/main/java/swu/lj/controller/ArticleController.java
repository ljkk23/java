package swu.lj.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
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
public class ArticleController {
    @Autowired
    private IArticleService articleService;

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
}

