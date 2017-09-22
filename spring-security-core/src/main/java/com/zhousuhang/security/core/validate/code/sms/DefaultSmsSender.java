package com.zhousuhang.security.core.validate.code.sms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultSmsSender implements SmsSender {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void send(String mobile, String code) {
		logger.info("mobile:"+mobile+",code:"+code);
	}

}
