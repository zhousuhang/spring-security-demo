/**
 * 
 */
package com.zhousuhang.security.core.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.zhousuhang.security.core.properties.SecurityConstants;


/**
 * @author zhailiang
 *
 */
public class AbstractChannelSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationSuccessHandler myAuthenticationSuccessHandler;
	
	@Autowired
	private AuthenticationFailureHandler myAuthenticationFailureHandler;
	
	protected void applyPasswordAuthenticationConfig(HttpSecurity http) throws Exception {
		http.formLogin()
			.loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
			.loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
			.successHandler(myAuthenticationSuccessHandler)
			.failureHandler(myAuthenticationFailureHandler);
	}
	
}