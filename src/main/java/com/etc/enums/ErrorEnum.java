package com.etc.enums;

public enum ErrorEnum {

	CHECK_ERROR(105),
	UNKNOWN_ERROR(100,"未知异常"),
	FIND_ERROR(101,"查询失败"),
	ADD_ERROR(102,"添加失败"),
	EDIT_ERROR(103,"修改失败"),
	REMOVE_ERROR(104,"删除失败");
	
	
	private Integer code;
	private String msg;
	
	private ErrorEnum(Integer code, String msg) {   //错误消息固定
		this.code = code;
		this.msg = msg;
	}
	private ErrorEnum(Integer code) {   //错误消息由他人提供
		this.code = code;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
