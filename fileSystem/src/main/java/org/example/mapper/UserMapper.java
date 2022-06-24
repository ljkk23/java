package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.pojo.User;
import org.springframework.stereotype.Component;


import java.util.Date;
import java.util.List;

@Mapper
public interface UserMapper{

    User SelectLoginUser(@Param("UserName") String UserName);

    User passWordVerify(@Param("UserName") String UserName,@Param("passWord") String passWord);

    int register(@Param("UserName") String UserName,@Param("passWord") String passWord);

    List<User> getUserList(Integer role);

    void deleteUser(String userName);

}
