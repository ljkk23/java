package swu.lj.service;

import swu.lj.domain.ResponseResult;
import swu.lj.domain.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author liujian
 * @since 2022-05-26
 */
public interface IUserService extends IService<User> {
    ResponseResult UpdateUserInfo(User user);

    ResponseResult register(User user);
}
