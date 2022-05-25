package swu.lj.mapper;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import swu.lj.domain.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 文章表 Mapper 接口
 * </p>
 *
 * @author liujian
 * @since 2022-05-20
 */
@Component
public interface ArticleMapper extends BaseMapper<Article> {

}
