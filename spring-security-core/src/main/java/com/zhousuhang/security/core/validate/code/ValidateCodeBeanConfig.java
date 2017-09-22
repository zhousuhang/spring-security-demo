package com.zhousuhang.security.core.validate.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zhousuhang.security.core.properties.SecurityProperties;
import com.zhousuhang.security.core.validate.code.image.ImageCodeGenerator;
import com.zhousuhang.security.core.validate.code.sms.DefaultSmsSender;
import com.zhousuhang.security.core.validate.code.sms.SmsSender;

@Configuration
public class ValidateCodeBeanConfig {
	
	@Autowired
	private SecurityProperties securityProperties;
	
	@Bean("imageValidateCodeGenerator")
	@ConditionalOnMissingBean(name="imageValidateCodeGenerator")
	public ValidateCodeGenerator imageCodeGenerator(){
		ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
		codeGenerator.setSecurityProperties(securityProperties);
		return codeGenerator;
	}
	
	@Bean
	@ConditionalOnMissingBean(SmsSender.class)
	public SmsSender smsCodeSender(){
		return new DefaultSmsSender();
	}

}
