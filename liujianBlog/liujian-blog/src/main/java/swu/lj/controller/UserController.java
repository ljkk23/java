package swu.lj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import swu.lj.annotation.systemLog;
import swu.lj.domain.ResponseResult;
import swu.lj.domain.entity.User;
import swu.lj.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @PutMapping("/userInfo")
    @systemLog(businessName = "更新")
    public ResponseResult getUserInfo(@RequestBody User user){
        return userService.UpdateUserInfo(user);
    }
    @PostMapping("/register")
    public ResponseResult register(@RequestBody User user){
        return userService.register(user);
    }
}
