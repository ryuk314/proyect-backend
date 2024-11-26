package com.microcervice.oauth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@SuppressWarnings("deprecation")
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService usuarioService ;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.userDetailsService(this.usuarioService).PasswordEncoder(paswordEncoder());
	}

	@Bean
	private static BCryptPasswordEncoder paswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	private AuthenticationManager AuthenticationManager() throws Exception(){
		return super.authenticationManager();
	}
}
