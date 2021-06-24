package com.datagrokr.integration.services;

import com.enhancesys.schema.impl.validators.PropertiesValidator;

public class Tester 
{
	public static void main(String[] args) 
	{
		String template= "{\"type\":\"object\",\"properties\":{\"envelope\":{\"type\":\"object\",\"properties\":{\"header\":{\"type\":\"object\",\"properties\":{\"userName\":{\"type\":\"string\"},\"password\":{\"type\":\"string\"},\"channel\":{\"type\":\"string\"}}},\"payload\":{\"type\":\"object\",\"properties\":{\"id\":{\"type\":\"number\"}}}}}}}";
		String request = "{\"envelope\":{\"header\":{\"userName\":\"uiadmin\",\"password\":\"uiadmin@123\",\"channel\":\"UI\"},\"payload\":{\"id\":5}}}";
		System.out.println(PropertiesValidator.validate(template, request));
	}

}
