package com.datagrokr.common;

public interface DataConstants 
{
	public static Long INVALID_REQUEST = -1001l;
	public static Long VALID_REQUEST = 1001l;
	
	public Long DB_ERROR_CODE = 5002l;
	public Long DB_CONNECTION_ERROR_CODE = 5001l;
	
	public static Long HTTP_OK=200l;
	public static Long HTTP_CREATED=201l;
	public static Long HTTP_BAD_REQUEST=400l;
	public static Long HTTP_UNAUTHORIZED=401l;
	public static Long HTTP_FORBIDDEN=403l;
	public static Long HTTP_NOT_FOUND=404l;
	public static Long HTTP_METHOD_NOT_ALLOWED=405l;
	public static Long HTTP_CONFLICT=409l;
	public static Long HTTP_INTERNAL_SERVER_ERROR=500l;
	public static Long HTTP_SERVICE_UNAVAILABLE=503l;

	public static String SUCCESS = "Successs";
	public static String FAILURE = "Failure";
	public static String ERROR = "Error";
	public static String ENVELOPE = "envelope";
	public static String PAYLOAD = "payload";

	public static Long SUCCESS_CODE = 100l;
	public static Long FAILURE_CODE = -101l;
	
}
