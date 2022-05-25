package com.example.sercurtydemo1.filter;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component

public class verifyCodeFilter extends GenericFilterBean {


    private String defaultFilterProcessUrl = "/login.html";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if ("POST".equalsIgnoreCase(request.getMethod()) && defaultFilterProcessUrl.equals(request.getServletPath())) {
            // 验证码验证
            String requestCaptcha = request.getParameter("code");
            String genCaptcha = (String) request.getSession().getAttribute("index_code");
//            System.out.println(genCaptcha);
            if (StringUtils.isEmpty(requestCaptcha)) {
                response.setContentType("application/json;charset=utf-8");
                PrintWriter writer = response.getWriter();
                //注意这里PrintWriter writer = response.getWriter();不能在设置type之前
                writer.write("验证码空");
                writer.flush();
                writer.close();
            }else if (!genCaptcha.toLowerCase().equals(requestCaptcha.toLowerCase())) {
                response.setContentType("application/json;charset=utf-8");
                PrintWriter writer = response.getWriter();
                //注意这里PrintWriter writer = response.getWriter();不能在设置type之前
                writer.write("验证码错误");
                writer.flush();
                writer.close();
            }else {

            }
        }
        filterChain.doFilter(request, response);
    }
}
