package swu.lj.service;

import swu.lj.domain.vo.UserVO;
import swu.lj.domain.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @author liujian
 * @since 2022-08-27
 */
public interface IMenuService extends IService<Menu> {
    List<String> getPermissions(Integer userID);
    List<String> getRoles(Integer userID);
    UserVO getUserVo(Integer userID);
}
