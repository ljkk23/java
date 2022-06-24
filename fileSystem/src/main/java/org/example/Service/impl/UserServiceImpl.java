package org.example.Service.impl;

import org.example.Service.UserService;
import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public void reg(User user) {
        userMapper.register(user.getUserName(), user.getPassWord());
    }
    //检测数据库是否有该用户
    @Override
    public Boolean getUser(User user) {
        User loginUser=userMapper.SelectLoginUser(user.getUserName());
        if (Objects.isNull(loginUser)){
            return false;
        }else {
            return true;
        }

    }

    @Override
    public Integer getNowUserRole(String userName) {
        return userMapper.SelectLoginUser(userName).getRole();
    }

    @Override
    public User passwordVerify(User user) {
        User loginUser=userMapper.passWordVerify(user.getUserName(), user.getPassWord());
        return loginUser;
    }

    @Override
    public List<User> getUserList(Integer role) {
        return userMapper.getUserList(role);
    }

    @Override
    public void deleteUser(String userName) {
        userMapper.deleteUser(userName);

    }
}
