package com.A7meD.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class MyConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService getuserDetails() {

		return new CustomUserDetailsServices();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Bean
	public DaoAuthenticationProvider daoProvider() {
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setUserDetailsService(getuserDetails());
		dao.setPasswordEncoder(passwordEncoder());
		return dao;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http//
				.authorizeRequests()//
				.antMatchers("/user/**")//
				.hasRole("USER")//
				.antMatchers("/**").permitAll()//
				.and()//
				.formLogin()//
				.loginPage("/login")//
				.loginProcessingUrl("/dologin")//
				.defaultSuccessUrl("/user/home")//
				.and()//
				.csrf().disable();
	}

}
