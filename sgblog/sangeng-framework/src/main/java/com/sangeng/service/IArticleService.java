package com.sangeng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sangeng.domain.ResponseResult;

import com.sangeng.domain.entity.Article;

/**
 * <p>
 * 文章表 服务类
 * </p>
 *
 * @author liujian
 * @since 2022-05-20
 */
public interface IArticleService extends IService<Article> {

    ResponseResult getHotArticleList();
}
