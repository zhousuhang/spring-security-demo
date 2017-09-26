package com.zhousuhang.security.core.social.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

import com.zhousuhang.security.core.properties.SecurityProperties;
import com.zhousuhang.security.core.social.qq.connect.QQConnectionFactory;

@Configuration
@ConditionalOnProperty(prefix = "zhousuhang.security.social.qq", name = "app-id")
public class QQAutoConfig extends SocialAutoConfigurerAdapter {

	@Autowired
	private SecurityProperties securityProperties;

	@Override
	protected ConnectionFactory<?> createConnectionFactory() {
		return new QQConnectionFactory(securityProperties.getSocial().getQq().getProviderId(),
				securityProperties.getSocial().getQq().getAppId(),
				securityProperties.getSocial().getQq().getAppSecret());
	}

}
