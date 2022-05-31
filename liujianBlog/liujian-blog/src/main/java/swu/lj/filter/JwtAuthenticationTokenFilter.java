package swu.lj.filter;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import swu.lj.domain.ResponseResult;
import swu.lj.domain.entity.UserDetailsImpl;
import swu.lj.enums.AppHttpCodeEnum;
import swu.lj.utils.JwtUtil;
import swu.lj.utils.RedisCache;
import swu.lj.utils.WebUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private RedisCache redisCache;
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        //获取请求token
        String token =httpServletRequest.getHeader("token");
        //如果没有token,直接放行给后面的fliter
        if (!StringUtils.hasText(token)){
            filterChain.doFilter(httpServletRequest,httpServletResponse);
            return;
        }
        Claims claims=null;
        try {
            claims = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
            //token超时  token非法
            //响应告诉前端需要重新登录
            ResponseResult result = ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);

            WebUtils.renderString(httpServletResponse, JSON.toJSONString(result));
            return;
        }
        String userID=claims.getSubject();
        UserDetailsImpl userDetails = redisCache.getCacheObject("blogLogin:" + userID);
        if (Objects.isNull(userDetails)){
            //redis中缓存过期，登陆超时
            ResponseResult responseResult=ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
            WebUtils.renderString(httpServletResponse,JSON.toJSONString(responseResult));
            return;
        }
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null,null);
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        filterChain.doFilter(httpServletRequest,httpServletResponse);

    }
}
