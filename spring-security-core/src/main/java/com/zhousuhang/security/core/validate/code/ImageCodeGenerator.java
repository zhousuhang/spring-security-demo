package com.zhousuhang.security.core.validate.code;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.ServletRequestUtils;

import com.zhousuhang.security.core.properties.SecurityProperties;

public class ImageCodeGenerator implements ValidateCodeGenerator {
	
	private SecurityProperties securityProperties;
	
	@Override
	public ImageCode generator(HttpServletRequest request) {
		char[] code = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
				'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
				'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5',
				'6', '7', '8', '9' };
		
		int width = ServletRequestUtils.getIntParameter(request, "width", securityProperties.getCode().getImage().getWidth());
		int height = ServletRequestUtils.getIntParameter(request, "height", securityProperties.getCode().getImage().getHeight());
		int length = securityProperties.getCode().getImage().getLength();
		int expireIn = securityProperties.getCode().getImage().getExpireIn();
		
		StringBuffer checkcode = new StringBuffer();
		for (int i = 0; i <length ; i++) {
			int generated = (new Random()).nextInt(62);
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
