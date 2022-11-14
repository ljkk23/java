package edu.swu.handler.security;

import com.alibaba.fastjson.JSON;
import edu.swu.domain.Result;
import edu.swu.enums.StatusCodeEnum;
import edu.swu.utils.WebUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        accessDeniedException.printStackTrace();
        Result result = Result.fail(StatusCodeEnum.AUTHORIZED);
        //响应给前端
        WebUtils.renderString(response, JSON.toJSONString(result));
    }
}