package com.datagrokr.integration.services.repo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.datagrokr.common.DataConstants;
import com.datagrokr.common.exceptions.RepositoryException;
import com.datagrokr.integration.services.entities.Conduct;

@Component
@Qualifier("datakrokrJpaRepository")
public class DatakrokrJpaRepository implements DatagrokrRepository
{
	private static Logger LOGGER = LoggerFactory.getLogger(DatakrokrJpaRepository.class);

	@Autowired
	protected ConductsJpaRepository jpaRepository;

	@Autowired
	protected NamedParameterJdbcTemplate jdbcTemplate;
	
	public DatakrokrJpaRepository()
	{
		try 
		{
			//			getEntityManager();	
		}
		catch (Exception e) 
		{
			LOGGER.error(e.getMessage(), e);
		}
	}

	@Override
	public Conduct createConduct(final Conduct conduct) throws RepositoryException 
	{
		LOGGER.debug("Entry createConduct : conduct : " + conduct);
		try 
		{
			conduct.setCreatedTime(new Date());
			conduct.setLastUpdatedTime(new Date());
			return jpaRepository.save(conduct);
		}
		catch (Exception e) 
		{
			throw new RepositoryException(DataConstants.DB_ERROR_CODE, e.getMessage(), e);
		}
		finally 
		{
			LOGGER.debug("Exit createConduct");
		}
	}

	@Override
	public long getConductsCount() throws RepositoryException 
	{
		LOGGER.debug("Entry getConductsCount");
		long count = 0l;
		try 
		{
			count =  jpaRepository.count();
		}
		catch (Exception e) 
		{
			throw new RepositoryException(DataConstants.DB_ERROR_CODE, e.getMessage(), e);
		}
		finally 
		{
			LOGGER.debug("Exit getConductsCount : count : " + count);
		}
		return count;
	}

	@Override
	public Conduct getConduct(final Long conductId) throws RepositoryException 
	{
		LOGGER.debug("Entry getConduct : conductId : " + conductId);
		try 
		{
			return jpaRepository.findById(conductId).get();
		}
		catch (Exception e) 
		{
			throw new RepositoryException(DataConstants.DB_ERROR_CODE, e.getMessage(), e);
		}
		finally 
		{
			LOGGER.debug("Exit getConduct");	
		}
	}

	@Override
	public Conduct updateConduct(final Conduct conduct) throws RepositoryException 
	{
		LOGGER.debug("Entry updateConduct : conduct : " + conduct);
		try 
		{
			if(jpaRepository.existsById(conduct.getId()))
				return jpaRepository.save(conduct);
			else
				throw new Exception("No value present");

		}
		catch (Exception e) 
		{
			throw new RepositoryException(DataConstants.DB_ERROR_CODE, e.getMessage(), e);
		}
		finally 
		{
			LOGGER.debug("Exit updateConduct");	
		}
	}

	@Override
	public Conduct deleteConduct(final Conduct conduct) throws RepositoryException 
	{
		LOGGER.debug("Entry deteleConduct : conduct : " + conduct);
		try 
		{
			return deleteConductById(conduct.getId());
		}
		catch (Exception e) 
		{
			throw new RepositoryException(DataConstants.DB_ERROR_CODE, e.getMessage(), e);
		}
		finally 
		{
			LOGGER.debug("Exit deleteConduct");	
		}
	}

	@Override
	public Conduct deleteConductById(final Long conductId) throws RepositoryException 
	{
		LOGGER.debug("Entry deleteConductById : conductId : " + conductId);
		try 
		{
			Conduct tempConduct = jpaRepository.findById(conductId).get();
			if(tempConduct != null)
			{
				jpaRepository.delete(tempConduct);
				return tempConduct;
			}
			else
				return null;
		}
		catch (Exception e) 
		{
			throw new RepositoryException(DataConstants.DB_ERROR_CODE, e.getMessage(), e);
		}
		finally 
		{
			LOGGER.debug("Exit deleteConductById");	
		}
	}

	@Override
	public List<Conduct> getAllConduct() throws RepositoryException 
	{
		LOGGER.debug("Entry getAllConduct");
		final List<Conduct> list = new ArrayList<Conduct>();
		try 
		{
			jpaRepository.findAll().forEach(conduct -> list.add(conduct));;
			return list;
		}
		catch (Exception e) 
		{
			throw new RepositoryException(DataConstants.DB_ERROR_CODE, e.getMessage(), e);
		}
		finally 
		{
			LOGGER.debug("Entry getAllConduct : list " + list);
		}
	}

	@Override
	public List<Conduct> saveConducts(List<Conduct> conducts) throws RepositoryException 
	{
		LOGGER.debug("Entry saveConducts : conduct : " + conducts);
		List<Conduct> conList = new ArrayList<Conduct>();
		try 
		{
			jpaRepository.saveAll(conducts).forEach(c -> conList.add(c));;
			return conList;
		}
		catch (Exception e) 
		{
			throw new RepositoryException(DataConstants.DB_ERROR_CODE, e.getMessage(), e);
		}
		finally 
		{
			LOGGER.debug("Exit saveConducts");
		}
	}

	@Override
	public boolean deleteAllConducts() throws RepositoryException 
	{
		
		LOGGER.debug("Entry deleteAllConducts");
		try 
		{
			jpaRepository.deleteAll();
			return true;
		}
		catch (Exception e) 
		{
			throw new RepositoryException(DataConstants.DB_ERROR_CODE, e.getMessage(), e);
		}
		finally 
		{
			LOGGER.debug("Exit deleteAllConducts");
		}
	}
	
}
