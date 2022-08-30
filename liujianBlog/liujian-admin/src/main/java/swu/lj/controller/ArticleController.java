package swu.lj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import swu.lj.domain.ResponseResult;
import swu.lj.domain.entity.Article;
import swu.lj.service.IArticleService;

@RestController
@RequestMapping("/content")
public class ArticleController {
    @Autowired
    private IArticleService articleServicel;
    @PostMapping("/article")
    public ResponseResult addArticle(@RequestBody Article article){
        return articleServicel.addArticle(article);
    }
}
