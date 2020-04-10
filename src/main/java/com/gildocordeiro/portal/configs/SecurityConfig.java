package com.gildocordeiro.portal.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gildocordeiro.portal.service.MyUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private MyUserDetailService myUserDetailService;
	
	//Vetor das URLs livres para todos
	private static final String[] PUBLIC_MATCHERS = {
			"/resources/**",
			"/","/inicio",
			"/registrar",
			"/salvarUsuario"
	};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		 		.antMatchers("/professor").hasRole("PROFESSOR")
		 		.antMatchers("/aluno").hasRole("ALUNO")
		 		.antMatchers("/adm").hasRole("ADM")
		 		.antMatchers(PUBLIC_MATCHERS).permitAll()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
			.and()
				.logout()
				.logoutSuccessUrl("/login?logout")
				.permitAll();
	}
	
	//segurança customizada com o UserDetails
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailService).passwordEncoder(passwordEncoder());
	}
	
	//cripotografia da senha
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); 
	}
	
//	@Autowired
//	protected void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
//		builder
//			.inMemoryAuthentication()
//			.withUser("gildo@gmail").password("123").roles("ADM")
//			.and()
//			.withUser("gileno@gmail").password("123").roles("USER");
//	}
}
