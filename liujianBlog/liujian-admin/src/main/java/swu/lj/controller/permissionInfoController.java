package swu.lj.controller;

import io.jsonwebtoken.Claims;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import swu.lj.domain.ResponseResult;
import swu.lj.domain.vo.UserPermissionInfoVO;
import swu.lj.domain.vo.UserVO;
import swu.lj.service.PermissionService;
import swu.lj.utils.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class permissionInfoController {
    @Autowired
    private PermissionService permissionService;
    @GetMapping("/getInfo")
    public ResponseResult getPermissionInfo(HttpServletRequest request){
        String jwt=request.getHeader("token");
        Claims claims=null;
        try {
            claims = JwtUtil.parseJWT(jwt);
        } catch (Exception e) {

            throw new RuntimeException("token过期");
        }
        String subject = claims.getSubject();
        Integer userID=Integer.valueOf(subject);
        List<String> permissions = permissionService.getPermissions(userID);
        List<String> roles = permissionService.getRoles(userID);
        UserVO userVo = permissionService.getUserVo(userID);

        return ResponseResult.okResult(new UserPermissionInfoVO(permissions,roles,userVo));
    }
}
