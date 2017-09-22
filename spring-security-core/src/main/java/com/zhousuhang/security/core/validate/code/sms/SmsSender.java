package com.zhousuhang.security.core.validate.code.sms;

public interface SmsSender {
	void send(String mobile, String code);
}
