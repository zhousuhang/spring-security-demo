package com.zhousuhang.demo.aspect;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAspect {
	@Around("execution(* com.zhousuhang.demo.controller.UserController.*(..))")
	public Object handlerControllerMethod(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("TimeAspect start");
		long startTime = new Date().getTime();
		Object[] args = pjp.getArgs();
		for (Object arg : args) {
			System.out.println("arg: "+arg);
		}
		Object object = pjp.proceed();
		System.out.println("TimeAspect time:"+ (new Date().getTime()-startTime));
		System.out.println("TimeAspect end");
		return object;
	}
}
