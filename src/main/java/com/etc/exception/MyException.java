package com.etc.exception;

import com.etc.enums.ErrorEnum;

public class MyException extends RuntimeException {
	
	private int code;
	
	public MyException(int code) {
		this.code = code;
	}

	public MyException(int code, String message) {
		super(message);
		this.code = code;
	}
	
	public MyException(ErrorEnum errorEnum, String message) {
		super(message);
		this.code = errorEnum.getCode();
	}

	public MyException(ErrorEnum errorEnum) {
		super(errorEnum.getMsg());
		this.code = errorEnum.getCode();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
	
}
