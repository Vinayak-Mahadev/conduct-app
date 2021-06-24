package com.datagrokr.integration.services.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.datagrokr.common.DataConstants;
import com.datagrokr.common.exceptions.ApplicationException;
import com.datagrokr.integration.services.entities.Conduct;
import com.datagrokr.integration.services.services.DatagrokrServices;

@RestController
public class ConductsActivator implements ConductsController
{
	private static Logger LOGGER = LoggerFactory.getLogger(ConductsActivator.class);

	@Autowired
	private DatagrokrServices datagrokrServices;

	@Override
	public Conduct createConduct(Conduct request) throws ApplicationException 
	{
		Conduct response = null;
		LOGGER.info("REQUEST :: " + request);
		try 
		{
			response =  datagrokrServices.createConduct(request);
			return response;
		}
		catch (ApplicationException e) 
		{
			throw e;
		}
		catch (Exception e) 
		{
			throw new ApplicationException(DataConstants.CONNECTION_ERROR_CODE, e.getMessage(), e);
		}
		finally 
		{
			LOGGER.info("RESPONSE :: " + response);	
			response = null;	
		}
	}

	@Override
	public Conduct getConduct(Long conductId) throws ApplicationException 
	{
		Conduct response = null;
		LOGGER.info("REQUEST :: conductId :: " + conductId);
		try 
		{
			response = datagrokrServices.getConduct(conductId);
			return response; 
		}
		catch (ApplicationException e) 
		{
			throw e;
		}
		catch (Exception e) 
		{
			throw new ApplicationException(DataConstants.CONNECTION_ERROR_CODE, e.getMessage(), e);
		}
		finally 
		{
			LOGGER.info("RESPONSE :: " + response);
			response = null;
		}
	}

	@Override
	public Conduct updateConduct(Conduct request) throws ApplicationException 
	{
		Conduct response = null;
		LOGGER.info("REQUEST :: " + request);
		try 
		{
			response = datagrokrServices.updateConduct(request);
			return response;
		}
		catch (ApplicationException e) 
		{
			throw e;
		}
		catch (Exception e) 
		{
			throw new ApplicationException(DataConstants.CONNECTION_ERROR_CODE, e.getMessage(), e);
		}
		finally 
		{
			LOGGER.info("RESPONSE :: " + response);
			response = null;
		}
	}

	@Override
	public Conduct deleteConduct(Conduct request) throws ApplicationException 
	{
		LOGGER.info("REQUEST :: " + request);
		Conduct response = null;
		try 
		{
			response = datagrokrServices.deleteConduct(request);
			return response;
		}
		catch (ApplicationException e) 
		{
			throw e;
		}
		catch (Exception e) 
		{
			throw new ApplicationException(DataConstants.CONNECTION_ERROR_CODE, e.getMessage(), e);
		}
		finally 
		{
			LOGGER.info("RESPONSE :: " + response);
			response = null;
		}
	}

	@Override
	public Conduct deleteConductById(Long conductId) throws ApplicationException 
	{
		LOGGER.info("REQUEST :: " + conductId);
		Conduct response = null;
		try 
		{
			response = datagrokrServices.deleteConductById(conductId);
			return response;
		}
		catch (ApplicationException e) 
		{
			throw e;
		}
		catch (Exception e) 
		{
			throw new ApplicationException(DataConstants.CONNECTION_ERROR_CODE, e.getMessage(), e);
		}
		finally 
		{
			LOGGER.info("RESPONSE :: " + response);	
			response = null;
		}
	}

	@Override
	public List<Conduct> getAllConduct() throws ApplicationException 
	{
		LOGGER.info("REQUEST :: getAllConduct");
		List<Conduct> response = null;
		try 
		{
			response =  datagrokrServices.getAllConduct();
			return response;
		}
		catch (ApplicationException e) 
		{
			throw e;
		}
		catch (Exception e) 
		{
			throw new ApplicationException(DataConstants.CONNECTION_ERROR_CODE, e.getMessage(), e);
		}
		finally 
		{
			LOGGER.info("RESPONSE :: " + response);
			response = null;	
		}
	}
	@Override
	public String loaddummyData() throws ApplicationException 
	{
		LOGGER.info("REQUEST :: getAllConduct");
		List<Conduct> list = null;
		String response = "{\"response\":\"failed\"}";
		try 
		{
			list =  datagrokrServices.getAllConduct();
			if(list == null || list.isEmpty())
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
			throw e;
		}
		catch (Exception e) 
		{
			throw new ApplicationException(DataConstants.CONNECTION_ERROR_CODE, e.getMessage(), e);
		}
		finally 
		{
			LOGGER.info("RESPONSE :: " + response);
			response = null;	
		}
	}

}