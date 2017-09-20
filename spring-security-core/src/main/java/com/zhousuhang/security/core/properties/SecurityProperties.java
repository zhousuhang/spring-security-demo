package com.zhousuhang.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="zhousuhang.security")
public class SecurityProperties {
	private BroswerProperties broswer = new BroswerProperties();

	public BroswerProperties getBroswer() {
		return broswer;
	}

	public void setBroswer(BroswerProperties broswer) {
		this.broswer = broswer;
	}
}
