package com.restaurant.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.restaurant.demo.service.UserService;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final UserService userService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.csrf().disable()
			.authorizeRequests()
				.antMatchers(HttpMethod.POST,"/users/registration").permitAll()
				.antMatchers(HttpMethod.GET,"/users/**").hasAnyAuthority("cliente","administrador")
				.antMatchers(HttpMethod.GET,"/products/**").hasAnyAuthority("cliente","administrador")
				.antMatchers(HttpMethod.POST,"/products/**").hasAnyAuthority("administrador")
				.antMatchers(HttpMethod.DELETE,"/products/**").hasAnyAuthority("administrador")
				.antMatchers("/bills/**").hasAnyAuthority("administrador")
			.anyRequest()
			.authenticated().and()
			.formLogin();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider());
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(bCryptPasswordEncoder);
		provider.setUserDetailsService(userService);
		return provider;
	}
	
	
	
}