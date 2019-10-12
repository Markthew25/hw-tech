package com.tech.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class HWTechSecurityConfig extends WebSecurityConfigurerAdapter {

	// add our user in memory for authentication

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserBuilder users = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication()
				.withUser(users.username("john").password("test123").roles("EMPLOYEE"))
				.withUser(users.username("mary").password("test123").roles("EMPLOYEE", "MANAGER"))
				.withUser(users.username("susan").password("test123").roles("EMPLOYEE", "ADMIN"));

	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		http.authorizeRequests()
//				.antMatchers("/").hasRole("EMPLOYEE")
//				.antMatchers("/leaders/**").hasRole("MANAGER")
//				.antMatchers("/systems/**").hasRole("ADMIN")
//				//.anyRequest().authenticated()
//				.and()
//					.formLogin()
//					.loginPage("/login")//we will create controller for this request mapping
//					.loginProcessingUrl("/user-authentication")//we get this for free Spring security
//					.permitAll()
//				.and()
//				.logout().permitAll();
//	}
	
	
	protected void configure(HttpSecurity http) throws Exception {
	    http
		    	.authorizeRequests().antMatchers("/")
		    		.hasRole("EMPLOYEE").anyRequest()
		    		.authenticated()
		    	.and()
			    .formLogin()
				.loginPage("/login")//we will create controller for this request mapping
				.loginProcessingUrl("/user-authentication")//we get this for free Spring security
				.permitAll()
			.and()
			.logout().permitAll();
	}

	
}
