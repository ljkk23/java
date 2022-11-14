package edu.swu.controller;

import edu.swu.Exception.SystemException;
import edu.swu.domain.Result;
import edu.swu.domain.UserDTO.loginUserDTO;
import edu.swu.enums.StatusCodeEnum;
import edu.swu.service.BlogLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;


@RestController
public class BlogLoginController {
    @Autowired
    private BlogLoginService blogLoginService;

        @PostMapping("/login")
        public Result login(@RequestBody loginUserDTO loginUserDTO){
            if (!StringUtils.hasText(loginUserDTO.getUsername())){
                throw new SystemException(StatusCodeEnum.REQUIRE_USERNAME);
            }
            return blogLoginService.login(loginUserDTO);
       }
//    @PostMapping("/logout")
//    public ResponseResult logout(){
//        return blogLoginService.logout();
//    }



    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        System.out.println(principal.toString());
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }
}
