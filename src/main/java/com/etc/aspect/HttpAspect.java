package com.etc.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class HttpAspect {
	
	private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
	
	@Pointcut("execution (* com.etc.controller.*.*(..))")
	public void logpc(){}
	
	@Before("logpc()")   //请求路径、请求方式、请求ip、请求的类和方法、请求参数
	public void logBefore(JoinPoint point){
		ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		
		//url
		logger.info("url={}", request.getRequestURI());
		//method : get post put delete
		logger.info("method={}", request.getMethod());
		//ip
		logger.info("ip={}", request.getRemoteAddr());
		//类和方法
		logger.info("class_method={}",point.getSignature().getDeclaringTypeName()+"."+
					point.getSignature().getName());  //类名.方法
		//参数
		logger.info("args={}",point.getArgs());
		
	}
	
	
	@AfterReturning(pointcut="logpc()",returning="object")   //响应数据
	public void logAfterRet(Object object){
		logger.info("response={}",object);
	}

}
