package com.datagrokr.common.exceptions;

public class ApplicationException extends Exception
{
	private static final long serialVersionUID = 1L;

	protected Long errorCode;
	
	protected String msg;

	public ApplicationException() 
	{
		super();
	}
	
	public ApplicationException(String msg) 
	{
		super(msg);
	}
	
	public ApplicationException(long errorCode) 
	{
		super();
		this.errorCode = errorCode;
	}
	
	public ApplicationException(long errorCode, String msg) 
	{
		super(msg + " : " + errorCode);
		this.errorCode = errorCode;
		this.msg = msg;
	}

	public ApplicationException(long errorCode, String msg, Throwable t) 
	{
		super(msg, t);
		this.errorCode = errorCode;
	}

	public Long getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Long errorCode) {
		this.errorCode = errorCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
