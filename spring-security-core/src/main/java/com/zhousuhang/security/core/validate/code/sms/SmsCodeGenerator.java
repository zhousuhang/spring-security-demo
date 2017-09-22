package com.zhousuhang.security.core.validate.code.sms;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import com.zhousuhang.security.core.properties.SecurityProperties;
import com.zhousuhang.security.core.validate.code.ValidateCode;
import com.zhousuhang.security.core.validate.code.ValidateCodeGenerator;

@Component("smsValidateCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SecurityProperties securityProperties;

	@Override
	public ValidateCode generate(ServletWebRequest request) {
		int expireIn = securityProperties.getCode().getSms().getExpireIn();
		String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
		logger.info("短信验证码是：" + code);
		ValidateCode smsCode = new ValidateCode(code, expireIn);

		return smsCode;
	}

	public void setSecurityProperties(SecurityProperties securityProperties) {
		this.securityProperties = securityProperties;
	}

}
