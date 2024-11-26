package com.microcervice.oauth.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.netflix.hystrix.util.Exceptions;

@Configuration
@EnableAuthorizationServer
public class AutotizationServerConfig extends AuthorizationServerConfigurerAdapter{
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private infoadicionaltoken infoToken;
	
	@Override //endpoint /oauth /token POST username, password, client id ,Claims
	public void configure(AuthoritationServerEndpointsConfigurer endpoints) throws Exceptions {
		
		tokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
		tokenEnhancerChain.setTokenEnhancer(Arrays.asList(infoToken,jwtAccesTokenConvertet()));
		endpoints.authenticationManager(authenticationManager)
		.tokenStore(jwtTokenStore())
		.accesTokenConvertet(jwtAccesTokenConvertet())
		.tokenEnhancer(tokenEnhancerChain);
	}

	
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exceptions{
		security.tokenKeyAccess("PermitAll()") //  /cauth/tokens
		.checkTokenAccess("isAuthenticated()");
	}
	
	
	public void configure(ClientDetailsSErviceConfigurer clients) throws Exceptions{
		clients.inMemory().withClient("BackEndApp")
		.secret(passwordEncoder.encode("conta123"))
		.scopes("read","write")
		.authorizedGrantTipes("pasword","refresh_token")
		.accestokenValiditySeconds(3600)
		.refreshTokenValiditySeconds(3600);
		
		//.and()
		//.withClient("FrondEnd")
		//.secret(passwordEncoder.encode("contra123r23"))
		//.scopes("read","write")
		//.authorizedGrantTipes("password","refresh_token")
		//.accestokenValiditySeconds(3600)
		//.refreshTokenValiditySeconds(3600);
		
		
		//podemos agregar mas clientes//
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
