package com.datagrokr.integration.services.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.datagrokr.common.DataConstants;
import com.datagrokr.common.exceptions.ApplicationException;
import com.datagrokr.common.exceptions.DatabaseException;
import com.datagrokr.integration.services.entities.Conduct;
import com.datagrokr.integration.services.repo.DatagrokrRepository;

@Service
public class DatagrokrServices 
{
	@Autowired
	@Qualifier("datakrokrJpaRepository")
	private DatagrokrRepository datakrokrRepository;

	public Conduct createConduct(final Conduct conduct) throws ApplicationException
	{
		try 
		{
			return datakrokrRepository.createConduct(conduct);
		}
		catch (DatabaseException e) 
		{
			throw new ApplicationException(e.getErrorCode(),e.getMessage(), e);
		}
		catch (Exception e) 
		{
			throw new ApplicationException(DataConstants.CONNECTION_ERROR_CODE, e.getMessage(), e);
		}
	}

	public Conduct getConduct(final Long conductId) throws ApplicationException
	{
		try 
		{
			return datakrokrRepository.getConduct(conductId);
		}
		catch (DatabaseException e) 
		{
			throw new ApplicationException(e.getErrorCode(),e.getMessage(), e);
		}
		catch (Exception e) 
		{
			throw new ApplicationException(DataConstants.CONNECTION_ERROR_CODE, e.getMessage(), e);
		}
	}

	public Conduct updateConduct(final Conduct conduct) throws ApplicationException
	{
		try 
		{
			return datakrokrRepository.updateConduct(conduct);
		}
		catch (DatabaseException e) 
		{
			throw new ApplicationException(e.getErrorCode(),e.getMessage(), e);
		}
		catch (Exception e) 
		{
			throw new ApplicationException(DataConstants.CONNECTION_ERROR_CODE, e.getMessage(), e);
		}
	}

	public Conduct deleteConduct(final Conduct conduct) throws ApplicationException
	{
		try 
		{
			return datakrokrRepository.deleteConduct(conduct);
		}
		catch (DatabaseException e) 
		{
			throw new ApplicationException(e.getErrorCode(),e.getMessage(), e);
		}
		catch (Exception e) 
		{
			throw new ApplicationException(DataConstants.CONNECTION_ERROR_CODE, e.getMessage(), e);
		}
	}

	public Conduct deleteConductById(final Long conductId) throws ApplicationException
	{
		try 
		{
			return datakrokrRepository.deleteConductById(conductId);
		}
		catch (DatabaseException e) 
		{
			throw new ApplicationException(e.getErrorCode(),e.getMessage(), e);
		}
		catch (Exception e) 
		{
			throw new ApplicationException(DataConstants.CONNECTION_ERROR_CODE, e.getMessage(), e);
		}
	}

	public List<Conduct> getAllConduct() throws ApplicationException 
	{
		try 
		{
			
			return datakrokrRepository.getAllConduct();
		}
		catch (DatabaseException e) 
		{
			throw new ApplicationException(e.getErrorCode(),e.getMessage(), e);
		}
		catch (Exception e) 
		{
			throw new ApplicationException(DataConstants.CONNECTION_ERROR_CODE, e.getMessage(), e);
		}
	}
	
}