package com.datagrokr.integration.services.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.datagrokr.common.DataConstants;
import com.datagrokr.common.exceptions.ApplicationException;
import com.datagrokr.integration.services.entities.Conduct;
import com.datagrokr.integration.services.services.DatagrokrServices;
import com.datagrokr.integration.services.util.ConductHelper;

@RestController
//@CrossOrigin(origins = "*")
public class UiConductsActivator implements UiConductController
{
	private static Logger LOGGER = LoggerFactory.getLogger(UiConductsActivator.class);

	@Autowired
	private ConductHelper conductHelper;

	@Autowired
	private DatagrokrServices datagrokrServices;

	@Override
	public List<Conduct> getAllConduct() throws ApplicationException 
	{
		Long requestId = conductHelper.getRequestId();
		List<Conduct> response = null;
		try 
		{
			LOGGER.info("REQUEST :: REQ_ID : " + requestId);
			response =  datagrokrServices.getAllConduct();
		}
		catch (ApplicationException e) 
		{

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
	public ResponseEntity<Conduct> getConduct(Long conductId) throws ApplicationException 
	{
		Long requestId = conductHelper.getRequestId();
		Conduct response = null;
		try 
		{
			LOGGER.info("REQUEST :: REQ_ID : conductId : " + requestId + " : "+ conductId);

			response =  datagrokrServices.getConduct(conductId);
			return ResponseEntity.ok().body(response);

		}
		catch (ApplicationException e) 
		{
			LOGGER.error(e.getMessage(), e);
			throw e;
		}
		catch (Exception e) 
		{
			LOGGER.error(e.getMessage(), e);
			throw new ApplicationException(DataConstants.HTTP_INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
		finally 
		{
			LOGGER.info("RESPONSE :: " + response);	
			response = null;
		}
	}

	@Override
	public Conduct createConduct(Conduct conduct) throws ApplicationException 
	{
		Long requestId = conductHelper.getRequestId();
		Conduct response = null;
		try 
		{
			LOGGER.info("REQUEST :: REQ_ID : " + requestId + " : "+ conduct);
			response =  datagrokrServices.createConduct(conduct);
		}
		catch (ApplicationException e) 
		{
			LOGGER.error(e.getMessage(), e);
		}
		catch (Exception e) 
		{
			LOGGER.error(e.getMessage(), e);
			throw new ApplicationException(DataConstants.HTTP_INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
		finally 
		{
			LOGGER.info("RESPONSE :: " + response);	
			conduct = null;
		}
		return response;
	}


	@Override
	public ResponseEntity<Conduct> updateConduct(Long conductId, Conduct  conduct) throws ApplicationException 
	{
		Long requestId = conductHelper.getRequestId();
		Conduct response = null;
		try 
		{
			LOGGER.info("REQUEST :: REQ_ID : conductId : " + requestId + " : " + conductId);
			response =  datagrokrServices.updateConduct(conduct);
			return ResponseEntity.ok(response);

		}
		catch (ApplicationException e) 
		{
			LOGGER.error(e.getMessage(), e);
			throw e;
		}
		catch (Exception e) 
		{
			LOGGER.error(e.getMessage(), e);
			throw new ApplicationException(DataConstants.HTTP_INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
		finally 
		{
			LOGGER.info("RESPONSE :: " + response);	
			response = null;
		}
	}
	
	@Override
	public Map<String, Boolean> deleteConduct(Long conductId) throws ApplicationException 
	{
		Long requestId = conductHelper.getRequestId();
		Conduct conduct = null;
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		try 
		{
			LOGGER.info("REQUEST :: REQ_ID : Conduct id " + requestId + " : "+ conductId);
			conduct =  datagrokrServices.deleteConductById(conductId);
			if(conduct != null)
				map.put("deleted", Boolean.TRUE);
			else
				map.put("deleted", Boolean.FALSE);
			return map;
		}
		catch (ApplicationException e) 
		{
			LOGGER.error(e.getMessage(), e);
			throw e;
		}
		catch (Exception e) 
		{
			LOGGER.error(e.getMessage(), e);
			throw new ApplicationException(DataConstants.HTTP_INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
		finally 
		{
			conduct = null;
			LOGGER.info("RESPONSE :: " + map);	
		}
	}

}