package com.zhousuhang.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 验证码处理器
 * 
 * @author mangolee
 *
 */
public interface ValidateCodeProcessor {
	
	String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";
	
	void create(ServletWebRequest request) throws Exception;

	void validate(ServletWebRequest request);

}
