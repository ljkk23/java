package edu.swu.service.impl;

import edu.swu.domain.Result;
import edu.swu.domain.UserDTO.loginUserDTO;
import edu.swu.domain.VO.BlogUserLoginVO;
import edu.swu.domain.VO.UserInfoVO;
import edu.swu.domain.entity.UserDetailImpl;
import edu.swu.service.BlogLoginService;
import edu.swu.utils.BeanCopyUtils;
import edu.swu.utils.JwtUtil;
import edu.swu.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import java.util.Objects;

@Service
public class BlogLoginServiceImpl implements BlogLoginService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;

    @Override
    public Result logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailImpl userDetails=(UserDetailImpl) authentication.getPrincipal();
        Integer userID = userDetails.getId();
        redisCache.deleteObject("blogLogin:"+userID);
        return Result.ok();
    }

    @Override
    public Result login(loginUserDTO user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if (Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或密码错误");
        }
        UserDetailImpl userDetailsimpl = (UserDetailImpl) authenticate.getPrincipal();
        String userID=userDetailsimpl.getId().toString();
        String jwt= JwtUtil.createJWT(userID);

        redisCache.setCacheObject("blogLogin:"+userID,userDetailsimpl);

        UserInfoVO userVO = BeanCopyUtils.copyBean(userDetailsimpl, UserInfoVO.class);
        BlogUserLoginVO blogUserLoginVO=new BlogUserLoginVO(jwt,userVO);
        return Result.ok(blogUserLoginVO);

    }
}
