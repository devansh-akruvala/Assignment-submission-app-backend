package com.devansh.AssignmentSubmissionApp.config;



import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.devansh.AssignmentSubmissionApp.service.UserDetailsServiceImpl;
import com.devansh.AssignmentSubmissionApp.utility.JwtFilter;

@Configuration
public class SecurityConfig {

	@Autowired
	private JwtFilter jwtFilter;
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);
	     http.csrf().disable().cors().disable()
	     .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	     .and().exceptionHandling()
	     .authenticationEntryPoint((request,response,ex) -> {
	    	 response.sendError(HttpServletResponse.SC_UNAUTHORIZED,ex.getMessage());
	     })
	     .and()
	     .authorizeHttpRequests().antMatchers("/api/auth/**").permitAll()
	     .anyRequest().authenticated();	
//	    
//		http. 
//		csrf().disable()
//		.authorizeHttpRequests()
//		.antMatchers("/api/auth/**")
//		.permitAll()
//		.anyRequest()
//		.authenticated()
//		.and()
//		.exceptionHandling()
//		.and()
//		.sessionManagement()
//		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		
		
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
		
	     
	     
	 }
	
	@Bean
	public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
}
