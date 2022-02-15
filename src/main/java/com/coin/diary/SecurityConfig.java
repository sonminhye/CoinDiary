package com.coin.diary;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.coin.diary.security.LoginFailureHandler;
import com.coin.diary.security.LoginSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) 
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() // 요청에 의해 보안검사 시작
			.antMatchers("/login").permitAll()
			.anyRequest().authenticated()
			.and().formLogin()
			.defaultSuccessUrl("/")
			.usernameParameter("userId")
			.passwordParameter("passWd")
			.loginProcessingUrl("/loginProcess")
			.successHandler(new LoginSuccessHandler())
			.failureHandler(new LoginFailureHandler()); // form login 방식으로 보안검증
	}
}
