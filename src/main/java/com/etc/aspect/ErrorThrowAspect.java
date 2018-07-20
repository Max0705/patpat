package com.etc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.etc.enums.ErrorEnum;
import com.etc.exception.MyException;

/**
 * @author wuxiaoyi
 * 用来做service层统一的异常捕获
 */
@Aspect
@Component
public class ErrorThrowAspect {

	@Pointcut("execution(public * com.etc.service.*.*(..))")
	public void error(){}
	
	
	/**
	 * 当service中的方法抛出异常，则再方法前后加上try-catch操作，在catch中，
	 * 根据方法名判断具体出错的方法是什么，再来具体抛出指定异常
	 * 
	 * @param point   //调用切点方法
	 * @return 
	 */
	@Around("error()")
	public Object catchMyException(ProceedingJoinPoint point) throws Exception{
		Object ret = null;
		try{
			ret = point.proceed();
		}catch(Throwable e){
			String methodName = point.getSignature().getName().toLowerCase();
			if(methodName.indexOf("add")!=-1||methodName.indexOf("insert")!=-1){
				throw new MyException(ErrorEnum.ADD_ERROR);
			}else if(methodName.indexOf("remove")!=-1||methodName.indexOf("delete")!=-1){
				throw new MyException(ErrorEnum.REMOVE_ERROR);
			}else if(methodName.indexOf("modify")!=-1||methodName.indexOf("update")!=-1){
				throw new MyException(ErrorEnum.EDIT_ERROR);
			}else if(methodName.indexOf("find")!=-1||methodName.indexOf("query")!=-1){
				throw new MyException(ErrorEnum.FIND_ERROR);
			}else{
				throw new Exception(e);
			}
		}
		return ret;		
	}
	
	
	/**
	 * 校验service中所有方法的返回值，如果返回值为false，并且方法名中含有增删改操作，
	 * 则抛出指定异常到界面上提示用户。如果返回值为null，并且方法名中含有查询字眼，则抛出查询异常到界面
	 * 
	 * @param point
	 * @param ret
	 */
	@AfterReturning(pointcut="error()",returning="ret")
	public void returnCheck(JoinPoint point,Object ret){
		String methodName = point.getSignature().getName().toLowerCase();
		if(ret != null){
			if(ret instanceof Boolean){
				boolean retValue = ((Boolean)ret).booleanValue();
				if(!retValue){
					if(methodName.indexOf("add")!=-1||methodName.indexOf("insert")!=-1){
						throw new MyException(ErrorEnum.ADD_ERROR);
					}else if(methodName.indexOf("remove")!=-1||methodName.indexOf("delete")!=-1){
						throw new MyException(ErrorEnum.REMOVE_ERROR);
					}else if(methodName.indexOf("modify")!=-1||methodName.indexOf("update")!=-1){
						throw new MyException(ErrorEnum.EDIT_ERROR);
					}
				}
			}
		}else{
			if(methodName.indexOf("find")!=-1||methodName.indexOf("query")!=-1){
				throw new MyException(ErrorEnum.FIND_ERROR);
			}
		}
		
		
	}
}
