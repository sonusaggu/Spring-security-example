package com.saggu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.saggu.services.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userDetailsService;
	
	@Bean
	
	public BCryptPasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	/*	 PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		 auth.inMemoryAuthentication()
		 .withUser("saggu").password(encoder.encode("saggu")).roles("admin").and()
		 .withUser("saggu1").password(encoder.encode("saggu1")).roles("user");*/
		 
		 
		 auth.userDetailsService(userDetailsService).passwordEncoder(encode());
	 }
	
	
	 protected void configure(HttpSecurity http) throws Exception {
		 http.headers().frameOptions().disable();
	       
	        http
	            .authorizeRequests()
	                .antMatchers("/**","/register","/h2/**").permitAll()
	                
	                .antMatchers("/admin")
	                .hasRole("ADMIN")
	                
	                .antMatchers("/user").hasRole("USER").anyRequest().authenticated()
	                
	                
	                .and().httpBasic()
	                .and().csrf().disable();
	                
	    }
}
