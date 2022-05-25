package com.example.rediscache.Service;

import com.example.rediscache.mapper.UserMapper;
import com.example.rediscache.polo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;


    @Override
    //@Cacheable(value = "user#3600")
    @Transactional(rollbackFor = Throwable.class)
    public User getUser(int id) {
        User user1=userMapper.selectByPrimaryKey(id);
        User user2=userMapper.selectByPrimaryKey(id);
        return user1;

    }
}
