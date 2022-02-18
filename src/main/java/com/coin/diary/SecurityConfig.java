package com.coin.diary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.coin.diary.security.CustomUserDetailsService;
import com.coin.diary.security.LoginFailureHandler;
import com.coin.diary.security.LoginSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) 
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		try {
			auth.userDetailsService(customUserDetailsService).passwordEncoder(encoder());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.authorizeRequests() // 요청에 의해 보안검사 시작
			.antMatchers("/login").permitAll()
			.antMatchers("/signUp").permitAll()
			.antMatchers("/saveUserInfo").permitAll();
		 
		 http.formLogin()
			.defaultSuccessUrl("/")
			.usernameParameter("username")
			.passwordParameter("password")
			.loginProcessingUrl("/loginProcess")
			.successHandler(new LoginSuccessHandler())
			.failureHandler(new LoginFailureHandler())
			.permitAll();
		 
	}
	
	@Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
