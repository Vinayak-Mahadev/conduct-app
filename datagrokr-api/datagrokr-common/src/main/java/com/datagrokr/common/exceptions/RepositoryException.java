package com.datagrokr.common.exceptions;

public class RepositoryException extends Exception
{
	private static final long serialVersionUID = 1L;

	protected Long errorCode;
	
	protected String msg;
	
	public RepositoryException() 
	{
		super();
	}
	
	public RepositoryException(long errorCode) 
	{
		super();
		this.errorCode = errorCode;
	}
	
	public RepositoryException(long errorCode, String msg) 
	{
		super(msg + " : " + errorCode);
		this.errorCode = errorCode;
		this.msg = msg;
	}

	public RepositoryException(long errorCode, String msg, Throwable t) 
	{
		super(msg, t);
		this.errorCode = errorCode;
	}
	
	public Long getErrorCode()
	{
		return errorCode;
	}
}
