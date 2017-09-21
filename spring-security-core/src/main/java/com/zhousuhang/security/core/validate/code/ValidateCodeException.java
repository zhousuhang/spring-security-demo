package com.zhousuhang.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;

public class ValidateCodeException extends AuthenticationException {

	private static final long serialVersionUID = 1345682614314980182L;

	public ValidateCodeException(String msg) {
		super(msg);
	}

}
