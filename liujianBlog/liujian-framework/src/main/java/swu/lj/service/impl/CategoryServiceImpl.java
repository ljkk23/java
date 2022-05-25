package swu.lj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import swu.lj.domain.ResponseResult;
import swu.lj.domain.entity.Category;
import swu.lj.mapper.CategoryMapper;
import swu.lj.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 分类表 服务实现类
 * </p>
 *
 * @author liujian
 * @since 2022-05-24
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    @Override
    public ResponseResult getCategoryList() {
        LambdaQueryWrapper<Category> categoryLambdaQueryWrapper=new LambdaQueryWrapper<>();
        categoryLambdaQueryWrapper.eq(Category::getStatus,)
    }
}
