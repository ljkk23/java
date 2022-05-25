package swu.lj.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import swu.lj.domain.entity.Category;

import java.util.List;

/**
 * <p>
 * 分类表 Mapper 接口
 * </p>
 *
 * @author liujian
 * @since 2022-05-25
 */
@Component
public interface CategoryMapper extends BaseMapper<Category> {
    @Select("select DISTINCT k.id,k.name from liujian_category k left join liujian_article u on k.id = u.category_id"
            + " ${ew.customSqlSegment}")
    List<Category> getBookAndUser(Page<Category> page, @Param(Constants.WRAPPER) QueryWrapper<Category> QueryWrapper);
}
