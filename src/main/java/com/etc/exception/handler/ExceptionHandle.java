package com.etc.exception.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etc.entity.JsonResult;
import com.etc.exception.MyException;

@ControllerAdvice
public class ExceptionHandle {

	private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
	
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public JsonResult handle(Exception e){
		logger.error("【系统异常】：", e);
		return new JsonResult(-1,"系统异常："+e.getMessage());
	}
	
	
	@ExceptionHandler(value=MyException.class)
	@ResponseBody
	public JsonResult handleMyException(MyException e){
		logger.error("【操作异常】：", e);
		return new JsonResult(e.getCode(),"操作异常："+e.getMessage());
	}
}
