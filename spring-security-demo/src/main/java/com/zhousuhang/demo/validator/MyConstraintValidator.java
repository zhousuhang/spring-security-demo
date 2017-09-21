package com.zhousuhang.demo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void initialize(MyConstraint constraintAnnotation) {
		logger.info("my validator init");
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		logger.info(value.toString());
		return true;
	}

}
