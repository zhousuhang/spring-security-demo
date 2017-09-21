package com.zhousuhang.security.core;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ResourceBundleMessageSource;

public class MyResourceBundleMessageSource extends ResourceBundleMessageSource {

	public MyResourceBundleMessageSource() {
		setBasename("com.zhousuhang.security.messages");
	}

	public static MessageSourceAccessor getAccessor() {
		return new MessageSourceAccessor(new MyResourceBundleMessageSource());
	}
	
	public static void main(String[] args) {
		MessageSourceAccessor messages = MyResourceBundleMessageSource.getAccessor();
		System.out.println(messages.getMessage("AbstractAccessDecisionManager.accessDenied"));
	}
}
