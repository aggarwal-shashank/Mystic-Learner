package com.astro.mysticlearner.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.astro.mysticlearner.Service.CustomUserDetailService;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired 
	CustomUserDetailService customUserDetailService;

	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		 .requestMatchers("/","/courses","/shopping","/about-us","/register/**","/course/{id}").permitAll()
		 .requestMatchers("/admin/**").hasRole("ADMIN")
		 .anyRequest()
		 .authenticated()
		 .and()
		 .formLogin()
		 .loginPage("/login")
		 .permitAll()
		 .failureUrl("/login?error=true")
		 .defaultSuccessUrl("/")
		 .usernameParameter("email")
		 .passwordParameter("password")
		 .and()
		 .logout()
		 .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		 .logoutSuccessUrl("/login")
		 .and()
		 .exceptionHandling()
		 .and()
		 .csrf()
		 .disable();
		
		return http.build();
		
	}
	

	  
	  @Bean 
	  public BCryptPasswordEncoder getPassword() { return new
	  BCryptPasswordEncoder(); }
	  
	  
	  @Bean 
	  public DaoAuthenticationProvider daoProvider() {
	  DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
	  dao.setUserDetailsService(customUserDetailService);
	  dao.setPasswordEncoder(getPassword()); return dao; }
	  
	  @Bean 
	  public AuthenticationManager authManager(HttpSecurity http) throws
	  Exception {
		  AuthenticationManagerBuilder authenticationManagerBuilder =
	  http.getSharedObject(AuthenticationManagerBuilder.class);
	  authenticationManagerBuilder.authenticationProvider(daoProvider());
	  
	  return authenticationManagerBuilder.build(); }
	  
	  
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() throws Exception {
		return (web) ->  web.ignoring().requestMatchers("/static/**","/resources/**","/Images/**","/css/**");
	}
}
