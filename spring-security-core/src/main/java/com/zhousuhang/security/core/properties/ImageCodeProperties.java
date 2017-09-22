package com.zhousuhang.security.core.properties;

public class ImageCodeProperties extends SmsCodeProperties {

	private int width = 56;
	private int height = 15;
	
	public ImageCodeProperties() {
		setLength(4);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
