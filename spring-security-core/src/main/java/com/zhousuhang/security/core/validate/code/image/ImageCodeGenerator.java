package com.zhousuhang.security.core.validate.code.image;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import com.zhousuhang.security.core.properties.SecurityProperties;
import com.zhousuhang.security.core.validate.code.ValidateCodeGenerator;

public class ImageCodeGenerator implements ValidateCodeGenerator {
	
	private SecurityProperties securityProperties;
	
	@Override
	public ImageCode generate(ServletWebRequest request) {
		char[] code = {'0', '1', '2', '3', '4', '5',
				'6', '7', '8', '9' };
		
		int width = ServletRequestUtils.getIntParameter(request.getRequest(), "width", securityProperties.getCode().getImage().getWidth());
		int height = ServletRequestUtils.getIntParameter(request.getRequest(), "height", securityProperties.getCode().getImage().getHeight());
		int length = securityProperties.getCode().getImage().getLength();
		int expireIn = securityProperties.getCode().getImage().getExpireIn();
		
		StringBuffer checkcode = new StringBuffer();
		for (int i = 0; i <length ; i++) {
			int generated = (new Random()).nextInt(10);
			checkcode.append(code[generated]);
		}
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.fillRect(0, 1, width, height);
		g.setColor(Color.black);
		g.drawString(checkcode.toString(), 4, 11);
		g.dispose();
		
		ImageCode imageCode = new ImageCode(image, checkcode.toString(), expireIn);
		
		return imageCode;
	}

	public void setSecurityProperties(SecurityProperties securityProperties) {
		this.securityProperties = securityProperties;
	}
	
}
