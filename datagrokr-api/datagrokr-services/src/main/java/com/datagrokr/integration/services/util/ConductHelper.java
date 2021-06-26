package com.datagrokr.integration.services.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.datagrokr.common.DataConstants;
import com.datagrokr.integration.services.bean.ServiceBean;
import com.datagrokr.integration.services.entities.Conduct;
import com.enhancesys.schema.impl.validators.PropertiesValidator;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@PropertySource({"classpath:config/schema.properties"})
public class ConductHelper 
{
	private static Logger LOGGER = LoggerFactory.getLogger(ConductHelper.class);

	@Autowired
	protected Environment environment;

	protected final ObjectMapper mapper;

	public ConductHelper()
	{
		mapper = new ObjectMapper();
	}

	public ServiceBean validateRequest(Long requestId, final ServiceBean serviceBean)
	{
		List<String> errorList = null; 
		JSONObject requestJson = null;
		JSONObject payload = null;
		ServiceBean responseBean = new ServiceBean();
		try 
		{
			if(serviceBean == null)
				return responseBean;
			requestJson = new JSONObject(serviceBean.getRequest());
			errorList = PropertiesValidator.validate(environment.getProperty(serviceBean.getRequestTemplate()), serviceBean.getRequest());
			payload = requestJson.getJSONObject(DataConstants.ENVELOPE).getJSONObject(DataConstants.PAYLOAD);
			LOGGER.debug("payload :: " + payload);
			responseBean.setRequestConduct(mapper.readValue(payload.toString(), Conduct.class));
			LOGGER.debug("conduct :: " + responseBean.getRequestConduct());
			if(errorList != null && !errorList.isEmpty())
			{
				responseBean.setMessage(errorList.toString());
				responseBean.setStatus(DataConstants.INVALID_REQUEST);				
			}
			else
				responseBean.setStatus(DataConstants.VALID_REQUEST);
			return responseBean;
		}
		catch (Exception e) 
		{
			responseBean.setMessage(e.getMessage());
			responseBean.setStatus(DataConstants.INVALID_REQUEST);
			return responseBean;
		}
		finally 
		{
			responseBean = null;
		}
	}


	private static long _request_id_ = 0;
	private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyMMddhhmmss");

	public synchronized long getRequestId()
	{
		try 
		{
			long temp = Long.parseLong(dateFormatter.format(new Date()));
			_request_id_ = (_request_id_ == temp) ? _request_id_ ++ : temp;
		}
		catch (Exception e) 
		{
			_request_id_ ++;
		}
		finally 
		{
			Thread.currentThread().setName("" + _request_id_);	
		}
		return _request_id_;
	}

	public static int getRandomNumber(int min, int max) 
	{
		return (int) ((Math.random() * (max - min)) + min);
	}

	public String prepareSuccessResponseForConduct(long resCode, long requestId, Conduct data, List<Conduct> conducts)
	{
		String response = null;
		JSONArray jsonArray = null;
		try
		{
			JSONObject responseObject = new JSONObject();
			responseObject.put("req_id", requestId);
			responseObject.put("res_code", resCode);
			responseObject.put("res_msg", "Request process succesfully...");
			if(data == null || data.getId() == null)
				responseObject.put("payload", new JSONObject());
			else
				responseObject.put("payload", new JSONObject(mapper.writeValueAsString(data)));
			if(conducts != null)
			{
				jsonArray = new JSONArray();
				for (Conduct conduct : conducts) 
					jsonArray.put(new JSONObject(mapper.writeValueAsString(conduct)));
				responseObject.put("payload", jsonArray);
			}
			response = responseObject.toString();
		}
		catch(Exception exception)
		{
			response = prepareExceptionResponseJson(requestId, "Failed", DataConstants.FAILURE_CODE);
		}
		return response;
	}

	public String prepareExceptionResponseJson(long requestId, String errorMsg, long errorCode)
	{
		String response = null;
		try
		{
			JSONObject responseObject = new JSONObject();
			responseObject.put("req_id", requestId);
			responseObject.put("res_code", errorCode);
			responseObject.put("res_msg", errorMsg);
			responseObject.put("payload", new JSONObject());
			response = responseObject.toString();
		}
		catch(Exception exception)
		{

		}
		return response;
	}
}
