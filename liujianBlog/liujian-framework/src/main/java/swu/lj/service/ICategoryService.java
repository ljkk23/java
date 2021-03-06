package swu.lj.service;

import swu.lj.domain.ResponseResult;
import com.baomidou.mybatisplus.extension.service.IService;
import swu.lj.domain.entity.Category;

/**
 * <p>
 * 分类表 服务类
 * </p>
 *
 * @author liujian
 * @since 2022-05-25
 */
public interface ICategoryService extends IService<Category> {
    ResponseResult getCategoryList();
}
