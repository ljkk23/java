package com.sangeng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.entity.Article;
import com.sangeng.mapper.ArticleMapper;
import com.sangeng.service.IArticleService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * <p>
 * 文章表 服务实现类
 * </p>
 *
 * @author liujian
 * @since 2022-05-20
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

    @Override
    public ResponseResult getHotArticleList() {
        LambdaQueryWrapper<Article> Qwrapper=new LambdaQueryWrapper<>();
        Qwrapper.eq(Article::getStatus,0)
                .orderByDesc(Article::getViewCount);
        Page<Article> page=new Page<>(1,10);
        page(page,Qwrapper);
        List<Article> articleList=page.getRecords();
        return ResponseResult.okResult(articleList);

    }
}
