package com.example.sercurtydemo1.config;

import com.example.sercurtydemo1.filter.verifyCodeFilter;
import com.example.sercurtydemo1.tools.VerifyCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.PrintWriter;

@Configuration
public class securityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    DataSource dataSource;
    @Autowired
    verifyCodeFilter verifyCodeFilter;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/vercode");
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager();
        manager.setDataSource(dataSource);
        if (!manager.userExists("javaboy")) {
            manager.createUser(User.withUsername("javaboy").password(new BCryptPasswordEncoder().encode("123")).roles("admin").build());
        }
        if (!manager.userExists("江南一点雨")) {
            manager.createUser(User.withUsername("江南一点雨").password("123").roles("user").build());
        }
        return manager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       // http.addFilterBefore(verifyCodeFilter, UsernamePasswordAuthenticationFilter.class);
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/user/**").hasRole("user")
                .anyRequest().authenticated()
                .and()
                .formLogin()
//                .loginPage()
//                .loginProcessingUrl("/doLogin")
                .defaultSuccessUrl("/index.html")
//                .successForwardUrl("/index.html")
//                .successHandler(((request, response, authentication) -> {
//                    Object principal = authentication.getPrincipal();
//                    response.setContentType("application/json;charset=utf-8");
//                    PrintWriter writer = response.getWriter();
//                    writer.write(new ObjectMapper().writeValueAsString(principal));
//                    writer.flush();
//                    writer.close();
//                }))

//                .failureHandler(((request, response, exception) -> {
//                    response.setContentType("application/json;charset=utf-8");
//                    PrintWriter writer = response.getWriter();
//                    writer.write(exception.getMessage());
//                    writer.flush();
//                    writer.close();
//                }))
//                .permitAll()
                .and()
                .rememberMe()
                .key("liujian")
                .and()
                .logout()
                .logoutSuccessHandler(((request, response, authentication) -> {

                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter writer = response.getWriter();
                    //注意这里PrintWriter writer = response.getWriter();不能在设置type之前
                    writer.write("注销成功");
                    writer.flush();
                    writer.close();
                }))
                .deleteCookies()
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .permitAll()
                .and()
                .csrf().disable();
    //            .exceptionHandling();
//                .authenticationEntryPoint(((request, response, authException) -> {
//                    response.setContentType("application/json;charset=utf-8");
//                    PrintWriter out = response.getWriter();
//
//                    out.write(authException.getMessage());
//
//                    out.flush();
//                    out.close();
//                }));
    }
    @Bean
    RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl hierarchy = new RoleHierarchyImpl();
        hierarchy.setHierarchy("ROLE_admin > ROLE_user");
        return hierarchy;
    }
}


