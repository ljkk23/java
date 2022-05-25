package swu.cs.lj.verifycode.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.net.PasswordAuthentication;
import java.util.Arrays;

@Configuration
public class securityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;
    @Bean
    PasswordEncoder myPassEncoder(){
        return new BCryptPasswordEncoder();
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

    @Bean
    myAuthenticationProvider MyAuthenticationProvider(){
        myAuthenticationProvider MyAuthProvider=new myAuthenticationProvider();
        MyAuthProvider.setPasswordEncoder(myPassEncoder());
        MyAuthProvider.setUserDetailsService(userDetailsService());
        return MyAuthProvider;

    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {

        ProviderManager providerManager=new ProviderManager(Arrays.asList(MyAuthenticationProvider()));
        return  providerManager;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/vc.jpg");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //这里是authorizeRequests。而不是authorizeHttpRequests
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")
//                .defaultSuccessUrl("/index.html")
//                .successForwardUrl("/index.html")
                .successHandler(((request, response, authentication) -> {
                    Object principal = authentication.getPrincipal();
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter writer = response.getWriter();
                    writer.write(new ObjectMapper().writeValueAsString(principal));
                    writer.flush();
                    writer.close();
                }))

                .failureHandler(((request, response, exception) -> {
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter writer = response.getWriter();
                    writer.write(exception.getMessage());
                    writer.flush();
                    writer.close();
                }))
                .permitAll()
                .and()
              //  .rememberMe()
              //  .key("liujian")
                //.and()
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
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(((request, response, authException) -> {
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter out = response.getWriter();

                    out.write(authException.getMessage());

                    out.flush();
                    out.close();
                }));
    }



}
