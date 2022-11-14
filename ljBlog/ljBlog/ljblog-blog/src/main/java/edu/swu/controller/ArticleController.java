package edu.swu.controller;

import edu.swu.Exception.SystemException;
import edu.swu.domain.Result;
import edu.swu.enums.StatusCodeEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @GetMapping("/hotArticleList")
    public Result hotArticleList() {
        throw new SystemException(StatusCodeEnum.NO_LOGIN);
        //return articleService.getHotArticleList();
    }
}
