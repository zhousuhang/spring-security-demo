package com.zhousuhang.security.core.authentication;

public class SimpleResponse {
	private Object content;

	public SimpleResponse(Object content) {
		super();
		this.content = content;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}
	
}
