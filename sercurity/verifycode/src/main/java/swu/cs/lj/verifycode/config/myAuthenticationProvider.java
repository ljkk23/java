package swu.cs.lj.verifycode.config;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

public class myAuthenticationProvider extends DaoAuthenticationProvider {
    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        String RequestCode=request.getParameter("code");
        String Sessioncode=(String) request.getSession().getAttribute("VC");
        if (RequestCode==null || Sessioncode==null || !Sessioncode.equals(RequestCode)){
            throw new AuthenticationServiceException("验证吗错误");
        }
        super.additionalAuthenticationChecks(userDetails, authentication);
    }
}
