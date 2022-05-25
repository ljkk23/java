package swu.lj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import swu.lj.domain.ResponseResult;
import swu.lj.domain.entity.Category;
import swu.lj.domain.vo.CategoryVO;
import swu.lj.mapper.CategoryMapper;
import swu.lj.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import swu.lj.utils.BeanCopyUtils;

import java.util.List;

import static swu.lj.Constants.SystemConstants.ARTICLE_STATUS_NORMAL;

/**
 * <p>
 * 分类表 服务实现类
 * </p>
 *
 * @author liujian
 * @since 2022-05-25
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public ResponseResult getCategoryList() {
        QueryWrapper<Category> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("k.status",ARTICLE_STATUS_NORMAL);
        Page<Category> CategoryPage=new Page<>(1,2);
        List<Category> bookAndUser = categoryMapper.getBookAndUser(CategoryPage, queryWrapper);
        List<CategoryVO> CategoryVOS = BeanCopyUtils.copyBeanList(bookAndUser, CategoryVO.class);
        return ResponseResult.okResult(CategoryVOS);
    }
}
