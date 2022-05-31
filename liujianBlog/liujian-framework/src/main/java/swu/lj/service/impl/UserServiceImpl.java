package swu.lj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.injector.methods.UpdateById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import swu.lj.Exception.SystemException;
import swu.lj.domain.ResponseResult;
import swu.lj.domain.entity.User;
import swu.lj.enums.AppHttpCodeEnum;
import swu.lj.mapper.UserMapper;
import swu.lj.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author liujian
 * @since 2022-05-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public ResponseResult register(User user) {
        //对数据进行非空判断
        if(!StringUtils.hasText(user.getUserName())){
            throw new SystemException(AppHttpCodeEnum.USERNAME_NOT_NULL);
        }
        if(!StringUtils.hasText(user.getPassword())){
            throw new SystemException(AppHttpCodeEnum.PASSWORD_NOT_NULL);
        }
        if(!StringUtils.hasText(user.getEmail())){
            throw new SystemException(AppHttpCodeEnum.EMAIL_NOT_NULL);
        }
        if(!StringUtils.hasText(user.getNickName())){
            throw new SystemException(AppHttpCodeEnum.NICKNAME_NOT_NULL);
        }
        //对数据进行是否存在的判断
        if(!userNameExist(user.getUserName())){
            throw new SystemException(AppHttpCodeEnum.USERNAME_EXIST);
        }
        if(!nickNameExist(user.getNickName())){
            throw new SystemException(AppHttpCodeEnum.NICKNAME_EXIST);
        }
        //...
        //对密码进行加密
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        //存入数据库
        save(user);
        return ResponseResult.okResult();
    }

    private boolean userNameExist(String name){
        LambdaQueryWrapper<User> usernameWrapper=new LambdaQueryWrapper<>();
        usernameWrapper.eq(User::getUserName,name);
        return Objects.isNull(getOne(usernameWrapper));
    }
    private boolean nickNameExist(String name){
        LambdaQueryWrapper<User> usernameWrapper=new LambdaQueryWrapper<>();
        usernameWrapper.eq(User::getNickName,name);
        return Objects.isNull(getOne(usernameWrapper));
    }
    @Override
    public ResponseResult UpdateUserInfo(User user) {
        if (updateById(user)){
            return ResponseResult.okResult();
        }
        return ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR.getCode(),"更新数据库出现问题");
    }
}
