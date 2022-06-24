package org.example.controller;

import org.example.Service.UserService;
import org.example.pojo.User;
import org.example.utils.toJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.FileNotFoundException;
import java.util.Objects;

@RestController
public class UserController{
    @Resource
    private UserService userService;

    @RequestMapping("reg")
    public toJson<String> RegUser(User user){//为什么是toJson<Void>,是因为在toJson 构造方法中不返回data的数据，所以data的类型就是Void，而在下面login中要返回data所以就应该是toJson<User>

        Boolean getUser=userService.getUser(user);
        if (getUser){
            return new toJson<String>("该用户名已经被用");
        }
        userService.reg(user);
        return new toJson<String>("成功注册");
    }
    @RequestMapping("login")
    public toJson<String> LoginUser(User user, HttpSession session){
        User loginUser=new User();
       Boolean getUser=userService.getUser(user);
       if (!getUser){
           return new toJson<String>("没有该用户");
       }else {
           loginUser=userService.passwordVerify(user);
           if (Objects.isNull(loginUser)){
               return new toJson<String>("密码错误");
           }
           if (userService.getNowUserRole(user.getUserName())==1){
               return new toJson<String>("成功登陆,1");
           } else
               return new toJson<String>("成功登陆,2");

       }
    }

    @RequestMapping("getUserList")
    public toJson getUserList(Integer role){
        return new toJson<>(userService.getUserList(role));
    }


    @RequestMapping("deleteUser")
    public toJson deleteFile(String userName){
        System.out.println(userName);
        userService.deleteUser(userName);
        return new toJson("成功删除user");
    }

}

