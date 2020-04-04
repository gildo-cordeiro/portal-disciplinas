package com.gildocordeiro.portal.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
//    private AccessDeniedHandler accessDeniedHandler;
    
    // roles admin allow to access /admin/**
    // roles user allow to access /user/**
    // custom 403 access denied handler
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests()
        .antMatchers("/admin").hasRole("ADMIN")
        .antMatchers("/user")
        .hasAnyRole("ADMIN","USER")
        .antMatchers("/")
        .permitAll().and()
        .formLogin();
    }
    
    UserDetailsService userDetailsService;
    
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) {
    	try {
			auth.userDetailsService(userDetailsService);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    @SuppressWarnings("deprecation")
	public PasswordEncoder getPasswordEncoder() {return NoOpPasswordEncoder.getInstance();}
}
