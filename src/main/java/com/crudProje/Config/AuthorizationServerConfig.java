package com.crudProje.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    
	@Value("${security.jwt.signing-key}")
	private String signingKey;
	
	@Autowired
     private AuthenticationManager authenticationManager;
	
	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(AccessTokenConverter());
	}
	
	@Bean
	public JwtAccessTokenConverter AccessTokenConverter() {
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		tokenConverter.setSigningKey(signingKey);
		return tokenConverter;
	}
     
     @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    	 endpoints
    	 .tokenStore(tokenStore())
    	 .accessTokenConverter(AccessTokenConverter())
    	 .authenticationManager(authenticationManager);
     }
     
     @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    	 clients
	    	 .inMemory()
	    	 .withClient("my-app")
	    	 .secret("@394")
	    	 .scopes("read", "write")
	    	 .authorizedGrantTypes("password")
	    	 .accessTokenValiditySeconds(1800);
     }
}
