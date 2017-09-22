package com.zhousuhang.security.core.validate.code;

import javax.servlet.http.HttpServletRequest;

public interface ValidateCodeGenerator {
	public ValidateCode generator(HttpServletRequest request);
}
