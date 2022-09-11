package edu.swu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import swu.lj.Exception.SystemException;
import swu.lj.domain.ResponseResult;
import swu.lj.domain.entity.User;
import swu.lj.enums.AppHttpCodeEnum;
import swu.lj.service.BlogLoginService;

@RestController
public class BlogLoginController {
    @Autowired
    private BlogLoginService blogLoginService;

        @PostMapping("/login")
        public ResponseResult login(@RequestBody User user){
            if (!StringUtils.hasText(user.getUserName())){
                throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
            }
            return blogLoginService.login(user);
        }
    @PostMapping("/logout")
    public ResponseResult logout(){
        return blogLoginService.logout();
    }
}
