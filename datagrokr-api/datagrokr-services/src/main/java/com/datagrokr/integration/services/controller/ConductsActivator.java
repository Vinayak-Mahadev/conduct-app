package com.datagrokr.integration.services.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.datagrokr.common.DataConstants;
import com.datagrokr.common.exceptions.ApplicationException;
import com.datagrokr.integration.services.bean.ServiceBean;
import com.datagrokr.integration.services.entities.Conduct;
import com.datagrokr.integration.services.services.DatagrokrServices;
import com.datagrokr.integration.services.util.ConductHelper;

@RestController
public class ConductsActivator implements ConductsController
{
	private static Logger LOGGER = LoggerFactory.getLogger(ConductsActivator.class);

	@Autowired
	private ConductHelper conductHelper;

	@Autowired
	private DatagrokrServices datagrokrServices;

	@Override
	public String createConduct(String requestData) throws ApplicationException 
	{
		Long requestId = conductHelper.getRequestId();
		ServiceBean serviceBean = null;
		Conduct conduct = null;
		String response = null;
		try 
		{
			LOGGER.info("REQUEST :: REQ_ID : " + requestId + " : "+ requestData);
			serviceBean = new ServiceBean();
			serviceBean.setRequest(requestData);
			serviceBean.setRequestTemplate("CREATE_CONDUCT");
			serviceBean.setRequestId(requestId);
			serviceBean = conductHelper.validateRequest(requestId, serviceBean);

			if(serviceBean.getStatus() == DataConstants.VALID_REQUEST && serviceBean.getRequestConduct() != null)
				conduct =  serviceBean.getRequestConduct();
			else
				throw new ApplicationException(serviceBean.getStatus(), serviceBean.getMessage());

			serviceBean.setResponseConduct(datagrokrServices.createConduct(conduct));

			response =  conductHelper.prepareSuccessResponseForConduct(DataConstants.SUCCESS_CODE, requestId, serviceBean.getResponseConduct(), null);

		}
		catch (ApplicationException e) 
		{
			response =  conductHelper.prepareExceptionResponseJson(requestId, e.getMessage(), e.getErrorCode());
		}
		catch (Exception e) 
		{
			LOGGER.error(e.getMessage(), e);
			throw new ApplicationException(DataConstants.HTTP_INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
		finally 
		{
			LOGGER.info("RESPONSE :: " + response);	
			serviceBean = null;
			conduct = null;
		}
		return response;
	}

	@Override
	public String getConduct(Long conductId) throws ApplicationException 
	{
		Long requestId = conductHelper.getRequestId();
		ServiceBean serviceBean = null;
		String response = null;
		try 
		{
			LOGGER.info("REQUEST :: REQ_ID : Conduct id " + requestId + " : "+ conductId);
			serviceBean = new ServiceBean();
			serviceBean.setRequestId(requestId);
			serviceBean.setResponseConduct(datagrokrServices.getConduct(conductId));
			response =  conductHelper.prepareSuccessResponseForConduct(DataConstants.SUCCESS_CODE, requestId, serviceBean.getResponseConduct(), null);
		}
		catch (ApplicationException e) 
		{
			response =  conductHelper.prepareExceptionResponseJson(requestId, e.getMessage(), e.getErrorCode());
		}
		catch (Exception e) 
		{
			LOGGER.error(e.getMessage(), e);
			throw new ApplicationException(DataConstants.HTTP_INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
		finally 
		{
			LOGGER.info("RESPONSE :: " + response);	
			serviceBean = null;
		}
		return response;
	}

	@Override
	public String updateConduct(String requestData) throws ApplicationException 
	{
		Long requestId = conductHelper.getRequestId();
		ServiceBean serviceBean = null;
		Conduct conduct = null;
		String response = null;
		try 
		{
			LOGGER.info("REQUEST :: REQ_ID : " + requestId + " : "+ requestData);
			serviceBean = new ServiceBean();
			serviceBean.setRequest(requestData);
			serviceBean.setRequestTemplate("UPDATE_CONDUCT");
			serviceBean.setRequestId(requestId);
			serviceBean = conductHelper.validateRequest(requestId, serviceBean);

			if(serviceBean.getStatus() == DataConstants.VALID_REQUEST && serviceBean.getRequestConduct() != null)
				conduct =  serviceBean.getRequestConduct();
			else
				throw new ApplicationException(serviceBean.getStatus(), serviceBean.getMessage());

			serviceBean.setResponseConduct(datagrokrServices.updateConduct(conduct));

			response =  conductHelper.prepareSuccessResponseForConduct(DataConstants.SUCCESS_CODE, requestId, serviceBean.getResponseConduct(), null);

		}
		catch (ApplicationException e) 
		{
			response =  conductHelper.prepareExceptionResponseJson(requestId, e.getMessage(), e.getErrorCode());
		}
		catch (Exception e) 
		{
			LOGGER.error(e.getMessage(), e);
			throw new ApplicationException(DataConstants.HTTP_INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
		finally 
		{
			LOGGER.info("RESPONSE :: " + response);	
			serviceBean = null;
			conduct = null;
		}
		return response;
	}

	@Override
	public String deleteConduct(Long conductId) throws ApplicationException 
	{
		Long requestId = conductHelper.getRequestId();
		ServiceBean serviceBean = null;
		String response = null;
		try 
		{
			LOGGER.info("REQUEST :: REQ_ID : Conduct id " + requestId + " : "+ conductId);
			serviceBean = new ServiceBean();
			serviceBean.setRequestId(requestId);
			serviceBean.setResponseConduct(datagrokrServices.deleteConductById(conductId));
			response =  conductHelper.prepareSuccessResponseForConduct(DataConstants.SUCCESS_CODE, requestId, serviceBean.getResponseConduct(), null);
		}
		catch (ApplicationException e) 
		{
			response =  conductHelper.prepareExceptionResponseJson(requestId, e.getMessage(), e.getErrorCode());
		}
		catch (Exception e) 
		{
			LOGGER.error(e.getMessage(), e);
			throw new ApplicationException(DataConstants.HTTP_INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
		finally 
		{
			LOGGER.info("RESPONSE :: " + response);	
			serviceBean = null;
		}
		return response;
	}

	@Override
	public String getAllConduct() throws ApplicationException 
	{
		Long requestId = conductHelper.getRequestId();
		String response = null;
		try 
		{
			LOGGER.info("REQUEST :: REQ_ID : " + requestId);
			response =  conductHelper.prepareSuccessResponseForConduct(DataConstants.SUCCESS_CODE, requestId, null, datagrokrServices.getAllConduct());
		}
		catch (ApplicationException e) 
		{
			response =  conductHelper.prepareExceptionResponseJson(requestId, e.getMessage(), e.getErrorCode());
		}
		catch (Exception e) 
		{
			LOGGER.error(e.getMessage(), e);
			throw new ApplicationException(DataConstants.HTTP_INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
		finally 
		{
			LOGGER.info("RESPONSE :: " + response);	
		}
		return response;
	}

	@Override
	public String loaddummyData() throws ApplicationException 
	{
		LOGGER.info("REQUEST :: loaddummyData");
		String response = "{\"response\":\"failed\"}";
		try 
		{
			if(datagrokrServices.getConductsCount() == 0)
			{
				if(datagrokrServices.loadDummyConducts())
					response = "{\"response\":\"success\"}";
			}
			else
			{
				response = "{\"response\":\"already data available\"}";
			}
			return response;
		}
		catch (ApplicationException e) 
		{
			LOGGER.error(e.getMessage(), e);
			throw e;
		}
		catch (Exception e) 
		{
			LOGGER.error(e.getMessage(), e);
			throw new ApplicationException(DataConstants.DB_CONNECTION_ERROR_CODE, e.getMessage(), e);
		}
		finally 
		{
			LOGGER.info("RESPONSE :: " + response);
			response = null;	
		}
	}

	@Override
	public String resetConducts() throws ApplicationException 
	{
		LOGGER.info("REQUEST :: getAllConduct");
		String response = "{\"response\":\"failed\"}";
		try 
		{
			if(datagrokrServices.getConductsCount() == 0)
			{
				response = "{\"response\":\"already data not available\"}";
			}
			else
			{
				if(datagrokrServices.deleteAllConducts())
					response = "{\"response\":\"success\"}";
			}
			return response;
		}
		catch (ApplicationException e) 
		{
			LOGGER.error(e.getMessage(), e);
			throw e;
		}
		catch (Exception e) 
		{
			LOGGER.error(e.getMessage(), e);
			throw new ApplicationException(DataConstants.DB_CONNECTION_ERROR_CODE, e.getMessage(), e);
		}
		finally 
		{
			LOGGER.info("RESPONSE :: " + response);
			response = null;	
		}
	}

}