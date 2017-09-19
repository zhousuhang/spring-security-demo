package com.zhousuhang.demo.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//@Component
public class TimeFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("my time filter init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("my time filter start");
		long startTime = new Date().getTime();
		chain.doFilter(request, response);
		System.out.println("my time filter: "+ (new Date().getTime()-startTime));
		System.out.println("my time filter finish");
	}

	@Override
	public void destroy() {
		System.out.println("my time filter destroy");
	}

}
