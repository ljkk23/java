package swu.lj.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import swu.lj.ssm.pojo.User;
import swu.lj.ssm.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login(String name, String pwd, HttpServletRequest request){
        User user=userService.login(name, pwd);
        if (user!=null){
            request.setAttribute("admin",user);
            return "main";
        }else {
            request.setAttribute("errmsg","err!!");
            return "login";
        }
    }

}
