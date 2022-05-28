package swu.lj.mapper;

import org.springframework.stereotype.Component;
import swu.lj.domain.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author liujian
 * @since 2022-05-26
 */
@Component
public interface UserMapper extends BaseMapper<User> {

}
