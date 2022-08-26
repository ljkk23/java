package swu.lj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import swu.lj.domain.ResponseResult;
import swu.lj.domain.entity.User;
import swu.lj.domain.entity.UserDetailsImpl;
import swu.lj.domain.vo.BlogUserLoginVO;
import swu.lj.domain.vo.UserVO;
import swu.lj.service.BlogLoginService;
import swu.lj.utils.BeanCopyUtils;
import swu.lj.utils.JwtUtil;
import swu.lj.utils.RedisCache;

import java.util.Objects;

@Service
public class BlogLoginServiceImpl implements BlogLoginService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails=(UserDetailsImpl) authentication.getPrincipal();
        Long userID = userDetails.getUser().getId();
        redisCache.deleteObject("blogLogin:"+userID);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if (Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或密码错误");
        }
        UserDetailsImpl userDetailsimpl = (UserDetailsImpl) authenticate.getPrincipal();
        String userID=userDetailsimpl.getUser().getId().toString();
        String jwt= JwtUtil.createJWT(userID);

        redisCache.setCacheObject("blogLogin:"+userID,userDetailsimpl);

        UserVO userVO = BeanCopyUtils.copyBean(userDetailsimpl.getUser(), UserVO.class);
        BlogUserLoginVO blogUserLoginVO=new BlogUserLoginVO(jwt,userVO);
        return ResponseResult.okResult(blogUserLoginVO);

    }
}
