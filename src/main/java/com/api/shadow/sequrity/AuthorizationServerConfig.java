package com.api.shadow.sequrity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
@PropertySource(value = { "classpath:sequrity.properties" })
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	static final int ACCESS_TOKEN_VALIDITY_SECONDS = 1 * 60 * 60;
	static final int FREFRESH_TOKEN_VALIDITY_SECONDS = 6 * 60 * 60;

	@Autowired
	private Environment environment;

	@Autowired
	private TokenStore tokenStore;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {

		configurer.inMemory().withClient(environment.getRequiredProperty("sequrity.clientId"))
				.secret(environment.getRequiredProperty("sequrity.client.secret"))
				.authorizedGrantTypes(environment.getRequiredProperty("sequrity.grant.type.password"),
						environment.getRequiredProperty("sequrity.authorization.code"),
						environment.getRequiredProperty("sequrity.refresh.token"),
						environment.getRequiredProperty("sequrity.implicit"))
				.scopes(environment.getRequiredProperty("sequrity.scope.read"),
						environment.getRequiredProperty("sequrity.scope.write"),
						environment.getRequiredProperty("sequrity.scope.trust"))
				.accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS)
				.refreshTokenValiditySeconds(FREFRESH_TOKEN_VALIDITY_SECONDS);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore).authenticationManager(authenticationManager);
	}
}
