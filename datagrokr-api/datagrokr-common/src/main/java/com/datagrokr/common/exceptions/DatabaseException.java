package com.datagrokr.common.exceptions;

public class DatabaseException extends Exception
{
	private static final long serialVersionUID = 1L;

	protected Long errorCode;
	
	protected String msg;
	
	public DatabaseException() 
	{
		super();
	}
	
	public DatabaseException(long errorCode) 
	{
		super();
		this.errorCode = errorCode;
	}
	
	public DatabaseException(long errorCode, String msg) 
	{
		super(msg + " : " + errorCode);
		this.errorCode = errorCode;
		this.msg = msg;
	}

	public DatabaseException(long errorCode, String msg, Throwable t) 
	{
		super(msg, t);
		this.errorCode = errorCode;
	}
	
	public Long getErrorCode()
	{
		return errorCode;
	}
}
