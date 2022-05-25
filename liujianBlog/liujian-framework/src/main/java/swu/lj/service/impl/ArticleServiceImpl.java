package swu.lj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swu.lj.domain.ResponseResult;
import swu.lj.domain.entity.Article;
import swu.lj.domain.entity.Category;
import swu.lj.domain.vo.ArticleDetailsVO;
import swu.lj.domain.vo.ArticleListVo;
import swu.lj.domain.vo.HotArticleVo;
import swu.lj.domain.vo.PageVo;
import swu.lj.mapper.ArticleMapper;
import swu.lj.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import swu.lj.service.ICategoryService;
import swu.lj.utils.BeanCopyUtils;

import java.util.List;
import java.util.Objects;

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

    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public ResponseResult getHotArticleList() {
        LambdaQueryWrapper<Article> Qwrapper=new LambdaQueryWrapper<>();
        Qwrapper.eq(Article::getStatus,ARTICLE_STATUS_NORMAL)
                .orderByDesc(Article::getViewCount);
        Page<Article> page=new Page<>(1,5);
        page(page,Qwrapper);
        List<Article> articleList=page.getRecords();
        List<HotArticleVo> hotArticleVoList = BeanCopyUtils.copyBeanList(articleList, HotArticleVo.class);
        return ResponseResult.okResult(hotArticleVoList);

    }

    @Override
    public ResponseResult getArticleDetails(long id) {
        LambdaQueryWrapper<Article> articleLambdaQueryWrapper=new LambdaQueryWrapper<>();
        articleLambdaQueryWrapper.eq(Article::getId,id)
                .eq(Article::getStatus,ARTICLE_STATUS_NORMAL);
        Article article = articleMapper.selectOne(articleLambdaQueryWrapper);
        ArticleDetailsVO articleDetailsVO = BeanCopyUtils.copyBean(article, ArticleDetailsVO.class);
        Category category = categoryService.getById(articleDetailsVO.getCategoryId());
        if(category!=null){
            articleDetailsVO.setCategoryName(category.getName());
        }
        return ResponseResult.okResult(articleDetailsVO);

    }

    @Override
    public ResponseResult getArticleList(Integer pageNum, Integer pageSize, Long categoryID) {

        LambdaQueryWrapper<Article> articleListVoLambdaQueryWrapper=new LambdaQueryWrapper<>();
        articleListVoLambdaQueryWrapper.eq(Objects.nonNull(categoryID),Article::getCategoryId,categoryID)
                .eq(Article::getStatus,ARTICLE_STATUS_NORMAL)
                .orderByDesc(Article::getIsTop);
        Page<Article> listVoPage=new Page<>(pageNum,pageSize);
        page(listVoPage,articleListVoLambdaQueryWrapper);
        List<Article> articles = listVoPage.getRecords();
//        articles.stream()
//                .map(article -> article.setCategoryName(categoryService.getById(article.getCategoryId()).getName()))
//                .collect(Collectors.toList())
        for (Article article : articles) {
            Category category = categoryService.getById(article.getCategoryId());
            article.setCategoryName(category.getName());
        }
        List<ArticleListVo> articleListVos = BeanCopyUtils.copyBeanList(articles, ArticleListVo.class);
        PageVo pageVo=new PageVo(articleListVos,listVoPage.getTotal());
        return ResponseResult.okResult(pageVo);

    }
}
