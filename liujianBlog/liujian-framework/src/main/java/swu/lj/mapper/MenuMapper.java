package swu.lj.mapper;

import org.springframework.stereotype.Component;
import swu.lj.domain.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import swu.lj.domain.vo.MenuVo;

import java.util.List;

/**
 * <p>
 * 菜单权限表 Mapper 接口
 * </p>
 *
 * @author liujian
 * @since 2022-08-27
 */
@Component
public interface MenuMapper extends BaseMapper<Menu> {
    List<String> selectPermsByUserId(Integer userId);

    List<Menu> selectRoutersByUserId(Integer userId);

    List<Menu> selectAllRouters();
}
