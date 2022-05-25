package com.sangeng.controller;


import com.sangeng.domain.ResponseResult;
import com.sangeng.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



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

}

