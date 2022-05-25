package swu.lj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import swu.lj.domain.ResponseResult;
import swu.lj.domain.entity.Article;
import swu.lj.domain.vo.HotArticleVo;
import swu.lj.mapper.ArticleMapper;
import swu.lj.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import swu.lj.utils.BeanCopyUtils;

import java.util.ArrayList;
import java.util.List;

import static swu.lj.Constants.SystemConstants.ARTICLE_STATUS_NORMAL;

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
        Qwrapper.eq(Article::getStatus,ARTICLE_STATUS_NORMAL)
                .orderByDesc(Article::getViewCount);
        Page<Article> page=new Page<>(1,10);
        page(page,Qwrapper);
        List<Article> articleList=page.getRecords();
        List<HotArticleVo> hotArticleVoList = BeanCopyUtils.copyBeanList(articleList, HotArticleVo.class);
        return ResponseResult.okResult(hotArticleVoList);

    }
}
