package com.zhousuhang.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "zhousuhang.security")
public class SecurityProperties {
	private BroswerProperties broswer = new BroswerProperties();

	private ValidateCodeProperties code = new ValidateCodeProperties();
	
	private SocialProperties social = new SocialProperties();

	public BroswerProperties getBroswer() {
		return broswer;
	}

	public void setBroswer(BroswerProperties broswer) {
		this.broswer = broswer;
	}

	public ValidateCodeProperties getCode() {
		return code;
	}

	public void setCode(ValidateCodeProperties code) {
		this.code = code;
	}

	public SocialProperties getSocial() {
		return social;
	}

	public void setSocial(SocialProperties social) {
		this.social = social;
	}


}
