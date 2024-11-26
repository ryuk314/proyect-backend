package com.microservice.zuul.oauth;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.microcervice.oauth.security.jwtAccesTokenConvertet;
import com.microcervice.oauth.security.jwtTokenStore;
import com.netflix.ribbon.proxy.annotation.Http.HttpMethod;

@Configuration
@EnableResourceServer
public class ResouceServerConfig extends ResouceServerConfigurationAdabter{
	
	public void configure(RecurceServerSecurityConfigurer resources) throws Exception{
		resources.TokenStore(jwtTokenStore());
	}

	public void configure(HttpSecurity http) throws Exception{
		http.authorizeRequest()
		.antMatchers("/api/security/oauth/**").permitAll()
		.antMatchers (HttpMethod.GET,"/api/phone/list","/api/tienda/list/","/apli/us/usuarios").permitAll()
		.antMatchers (HttpMethod.GET,"/api/phone/celular/(id)","/api/tienda/celular/(id)/cantidad/(cantidad)").hasAnyRole("ADMIN","USER")
		.antMatchers(HttpMethod.POST, "/api/phone/celular","/api/us/usuarios/".hasRole(ADMIN)
		.antMatchers(HttpMethod.PUT, "/api/phone/celular/(id)","/api/us/usuarios/(id".hasRole(ADMIN)
		.antMatchers(HttpMethod.DELETE, "/api/phone/celular/(id)","/api/us/usuarios/(id".hasRole(ADMIN)
		.anyRequest().authenticated();
		
	}

	@Bean
    public jwtTokenStore jwtTokenStore() {
		return new jwtTokenStore(jwtAccesTokenConvertet());
	}
    
    @Bean
    public jwtAccesTokenConvertet jwtAccesTokenConvertet() {
    	jwtAccesTokenConvertet tokenConvertet = new jwtAccesTokenConvertet();
    	tokenConvertet.setSigningKey("llabe_bellica_4x4");
    	return tokenConvertet;
    }
    
}
