package edu.swu.controller;

import edu.swu.Exception.SystemException;
import edu.swu.domain.ResponseResult;
import edu.swu.enums.AppHttpCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @GetMapping("/hotArticleList")
    public ResponseResult hotArticleList() {
        throw new SystemException(AppHttpCodeEnum.CONTENT_NOT_NULL);
        //return articleService.getHotArticleList();
    }
}
