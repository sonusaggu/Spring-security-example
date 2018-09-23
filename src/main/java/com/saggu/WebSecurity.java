package com.saggu;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		 auth.inMemoryAuthentication()
		 .withUser("saggu").password(encoder.encode("saggu")).roles("admin").and()
		 .withUser("saggu1").password(encoder.encode("saggu1")).roles("user");
	 }
	
	
	 protected void configure(HttpSecurity http) throws Exception {

	       
	        http
	            .authorizeRequests()
	                .antMatchers("/","/register").permitAll()
	                .and().authorizeRequests()
	                .antMatchers("/admin").hasRole("admin")
	                .and().authorizeRequests()
	                .antMatchers("/user").hasRole("user")
	                .anyRequest().authenticated()
	                .and().httpBasic()
	                .and().csrf().disable();
	                
	    }
}
