package com.zhousuhang.demo.aspect;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAspect {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Around("execution(* com.zhousuhang.demo.controller.UserController.*(..))")
	public Object handlerControllerMethod(ProceedingJoinPoint pjp) throws Throwable{
		logger.info("TimeAspect start");
		long startTime = new Date().getTime();
		Object[] args = pjp.getArgs();
		for (Object arg : args) {
			logger.info("arg: "+arg);
		}
		Object object = pjp.proceed();
		logger.info("TimeAspect time:"+ (new Date().getTime()-startTime));
		logger.info("TimeAspect end");
		return object;
	}
}
