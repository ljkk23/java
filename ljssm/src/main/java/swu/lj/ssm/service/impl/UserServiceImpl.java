package swu.lj.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swu.lj.ssm.mapper.UserMapper;
import swu.lj.ssm.pojo.User;
import swu.lj.ssm.pojo.UserExample;
import swu.lj.ssm.service.UserService;
import swu.lj.ssm.utils.MD5Util;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    public User login(String name, String pwd) {
        UserExample userExample=new UserExample();

        userExample.createCriteria().andUserNameEqualTo(name);
        List<User> userList=userMapper.selectByExample(userExample);
        if (userList.size()!=0){
            User user=userList.get(0);
            if (MD5Util.getMD5(pwd).equals(user.getUserPassword())){
                return user;
            }
        }
        return null;
    }
}
