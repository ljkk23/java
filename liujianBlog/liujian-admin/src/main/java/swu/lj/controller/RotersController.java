package swu.lj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import swu.lj.domain.ResponseResult;
import swu.lj.domain.vo.MenuVo;
import swu.lj.service.RouterService;
import swu.lj.utils.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping()
public class RotersController {
    @Autowired
    private RouterService routerService;
    @GetMapping("/getRouters")
    public ResponseResult getRouters(HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("token");
        Integer userID;
        try {
            userID= Integer.valueOf(JwtUtil.parseJWT(token).getSubject());
        } catch (Exception e) {
            throw new RuntimeException("token出错");
        }
        List<MenuVo> menuVos=routerService.getRoutersByUserID(userID);
        return ResponseResult.okResult(menuVos);
    }
}
