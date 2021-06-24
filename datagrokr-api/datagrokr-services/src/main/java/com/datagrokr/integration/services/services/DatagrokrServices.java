package com.datagrokr.integration.services.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
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

	public boolean loadDummyConducts() throws ApplicationException
	{
		List<Conduct> conducts = null;
		Conduct conduct = null;
		String line = null;
		BufferedReader reader = null;
		try 
		{
			conducts = new ArrayList<Conduct>();
			reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8));
			while ((line = reader.readLine()) != null)
			{
				String[] arr = line.split("\\|");
				conduct = new Conduct();
				conduct.setId(Long.parseLong(arr[0]));
				conduct.setName(arr[1]);
				conduct.setFirstName(arr[2]);
				conduct.setLastName(arr[3]);
				conduct.setEmailId(arr[4]);
				conduct.setPhoneNumber(Long.parseLong(arr[5]));
				conduct.setCity(arr[6]);
				conduct.setState(arr[7]);
				conduct.setCountry(arr[8]);
				conduct.setPincode(Long.parseLong(arr[9]));
				conduct.setCreatedTime(new Date());
				conduct.setLastUpdatedTime(new Date());
				conducts.add(conduct);
			}
			return datakrokrRepository.saveConducts(conducts);
		}
		catch (DatabaseException e) 
		{
			throw new ApplicationException(e.getErrorCode(),e.getMessage(), e);
		}
		catch (Exception e) 
		{
			throw new ApplicationException(DataConstants.CONNECTION_ERROR_CODE, e.getMessage(), e);
		}
		finally 
		{
			try 
			{
				if(reader != null)
					reader.close();
			}
			catch (Exception e2) 
			{
			}
			if(conducts != null)
				conducts.clear();
			conducts = null;
		}
	}

	@Value("classpath:config/dummy.csv")
    private ClassPathResource resource;
}