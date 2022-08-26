package swu.lj.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import swu.lj.annotation.systemLog;
import swu.lj.domain.ResponseResult;
import swu.lj.domain.dto.loginUserDTO;
import swu.lj.domain.entity.User;
import swu.lj.domain.vo.BlogUserLoginVO;
import swu.lj.service.IUserService;
import swu.lj.utils.BeanCopyUtils;

@RestController
@RequestMapping("/user")
@Api(tags = "用户注册以及修改个人信息")
public class UserController {
    @Autowired
    private IUserService userService;
    @PutMapping("/userInfo")
    @systemLog(businessName = "更新")
    @ApiOperation(value = "更新用户信息")
    public ResponseResult getUserInfo(@RequestBody loginUserDTO user){

        return userService.UpdateUserInfo(BeanCopyUtils.copyBean(user, User.class));
    }
    @PostMapping("/register")
    public ResponseResult register(@RequestBody User user){
        return userService.register(user);
    }
}
