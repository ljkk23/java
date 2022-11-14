package edu.swu.handler.security;

import com.alibaba.fastjson.JSON;
import edu.swu.domain.Result;
import edu.swu.enums.StatusCodeEnum;
import edu.swu.utils.WebUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        System.out.println("ddd");
        authException.printStackTrace();
        //InsufficientAuthenticationException
        //BadCredentialsException
        Result result = null;
        if(authException instanceof BadCredentialsException){
            result = Result.fail(StatusCodeEnum.LOGIN_ERROR.getCode(),authException.getMessage());
        }else if(authException instanceof InsufficientAuthenticationException){
            result = Result.fail(StatusCodeEnum.NO_LOGIN);
        }else{
            result = Result.fail(StatusCodeEnum.AUTHORIZED,"认证或授权失败");
        }
        //响应给前端
        WebUtils.renderString(response, JSON.toJSONString(result));
    }
}