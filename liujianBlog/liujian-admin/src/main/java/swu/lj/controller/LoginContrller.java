package swu.lj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import swu.lj.domain.ResponseResult;
import swu.lj.domain.entity.User;
import swu.lj.service.BlogAdminLoginService;
import swu.lj.utils.JwtUtil;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginContrller {

    @Autowired
    private BlogAdminLoginService blogAdminLoginService;
    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user){
        return blogAdminLoginService.login(user);
    }
    @PostMapping("/user/logout")
    public ResponseResult logout(HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("token");
        Integer userID;
        try {
            userID= Integer.valueOf(JwtUtil.parseJWT(token).getSubject());
        } catch (Exception e) {
            throw new RuntimeException("token出错");
        }
        return blogAdminLoginService.logout(userID);
    }

}