package swu.lj.mybatisplusdemo.service.impl;

import swu.lj.mybatisplusdemo.entity.User;
import swu.lj.mybatisplusdemo.mapper.UserMapper;
import swu.lj.mybatisplusdemo.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liujian
 * @since 2022-05-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
