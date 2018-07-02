package com.forward.spring.boot.blog.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/css/**","/js/**","/fonts/**","/index").permitAll()//都可以访问
            .antMatchers("/users/**").hasRole("ADMIN")//需要相应的角色才能访问
            .and()
            .formLogin()//基于Form表单登陆验证
            .loginPage("/login").failureUrl("/login-error");//自定义登陆界面
        //super.configure(http);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()//认证信息存储于内存中
        .withUser("admin").password("123456").roles("ADMIN");
    }
}
