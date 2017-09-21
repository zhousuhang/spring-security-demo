package com.zhousuhang.demo.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Component
public class TimeFilter implements Filter {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("my time filter init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.info("my time filter start");
		long startTime = new Date().getTime();
		chain.doFilter(request, response);
		logger.info("my time filter: "+ (new Date().getTime()-startTime));
		logger.info("my time filter finish");
	}

	@Override
	public void destroy() {
		logger.info("my time filter destroy");
	}

}
