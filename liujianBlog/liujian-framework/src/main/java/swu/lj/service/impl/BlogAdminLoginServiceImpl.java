package swu.lj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import swu.lj.Constants.SystemConstants;
import swu.lj.domain.ResponseResult;
import swu.lj.domain.entity.User;
import swu.lj.domain.entity.UserDetailsImpl;
import swu.lj.domain.vo.BlogUserLoginVO;
import swu.lj.domain.vo.UserVO;
import swu.lj.enums.AppHttpCodeEnum;
import swu.lj.service.BlogAdminLoginService;
import swu.lj.utils.BeanCopyUtils;
import swu.lj.utils.JwtUtil;
import swu.lj.utils.RedisCache;

import java.util.Objects;

@Service
public class BlogAdminLoginServiceImpl implements BlogAdminLoginService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;
    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authenticate= authenticationManager.authenticate(authenticationToken);
        if (Objects.isNull(authenticate)){
            throw new RuntimeException("账号或密码错误！");
        }
        UserDetailsImpl userDetails=(UserDetailsImpl)authenticate.getPrincipal();
        String UserID=userDetails.getUser().getId().toString();
        String jwt= JwtUtil.createJWT(UserID);
        redisCache.setCacheObject("blogAdmin:"+UserID,userDetails);

        UserVO userVO= BeanCopyUtils.copyBean(userDetails.getUser(),UserVO.class);
        BlogUserLoginVO blogUserLoginVO=new BlogUserLoginVO(jwt,userVO);
        return ResponseResult.okResult(blogUserLoginVO);
    }

    @Override
    public ResponseResult logout(Integer userId) {
        redisCache.deleteObject("blogAdmin:"+userId);
        return ResponseResult.okResult("成功注销");
    }
}
