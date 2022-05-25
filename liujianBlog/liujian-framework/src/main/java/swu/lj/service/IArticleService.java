package swu.lj.service;

import swu.lj.domain.ResponseResult;
import swu.lj.domain.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;

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
