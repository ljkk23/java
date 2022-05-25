package swu.lj.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import swu.lj.mybatisplusdemo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liujian
 * @since 2022-05-17
 */
@Component
public interface UserMapper extends BaseMapper<User> {
    // 这里采用纯注解方式。当然，若SQL比较复杂，建议还是采用XML的方式
    @Select("SELECT * FROM user ${ew.customSqlSegment}")
    Page<User> selectUserPage(Page<User> page, @Param(Constants.WRAPPER) Wrapper<User> wrapper);

}
