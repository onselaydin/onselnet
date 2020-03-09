package com.onsel.onselnet;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(http);
		//Burası boşken http://localhost:8080/rest/owners adresine direk girebildik.
		//Aşağıdaki satırlar ile güvenliği yönetiyoruz.
		
		http.authorizeRequests().antMatchers("/**/favicon.ico","/css/**","/js/**","/images/**","/webjars/**","/login.html").permitAll(); //bu klasörlere erişilebilsin...
		http.authorizeRequests().anyRequest().authenticated(); //güvenliğe tabi tut.
		http.formLogin().loginPage("/login.html").loginProcessingUrl("/login").failureUrl("/login.html?loginFailed=true");  // login ekranını getir.
	}	
	
}
