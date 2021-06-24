package com.datagrokr.integration.services.conf;
//package com.datagrokr.integration.conf;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableWebSecurity
//public class AppWebSecurityConfigurerAdapter  extends WebSecurityConfigurerAdapter
//{
//
//	@Autowired
//	protected PasswordEncoder passwordEncoder;
//
//	@Bean
//	public PasswordEncoder getPasswordEncoder()
//	{
//		return new  BCryptPasswordEncoder();
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
////	    http.authorizeRequests()
////	      .anyRequest().authenticated()
////	      .and().httpBasic();
////	    
//		http = http.csrf().disable();
//		
//	    http.authorizeRequests()
//	      .antMatchers("/home").access("hasRole('USER')")
//	      .antMatchers("/**").hasRole("ADMIN")
//	      .and()
//	      // some more method calls
//	      .httpBasic();
//	}
//	
//	@Override
//    public void configure(AuthenticationManagerBuilder auth)   throws Exception 
//	{
//        auth.inMemoryAuthentication().withUser(SERVICE_ADMIN_USERNAME).password(passwordEncoder.encode(SERVICE_ADMIN_PASSWORD)).roles("ADMIN");
//        auth.inMemoryAuthentication().withUser(SERVICE_USER_USERNAME).password(passwordEncoder.encode(SERVICE_USER_PASSWORD)).roles("USER");
//    }
//	
//	@Value("${SERVICE_ADMIN_USERNAME}")
//	private String SERVICE_ADMIN_USERNAME;
//	
//	@Value("${SERVICE_ADMIN_PASSWORD}")
//	private String SERVICE_ADMIN_PASSWORD;
//	
//	@Value("${SERVICE_USER_USERNAME}")
//	private String SERVICE_USER_USERNAME;
//	
//	@Value("${SERVICE_USER_PASSWORD}")
//	private String SERVICE_USER_PASSWORD;
//}
