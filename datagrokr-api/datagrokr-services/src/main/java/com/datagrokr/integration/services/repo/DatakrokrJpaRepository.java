package com.datagrokr.integration.services.repo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.datagrokr.common.DataConstants;
import com.datagrokr.common.exceptions.DatabaseException;
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
	public Conduct createConduct(final Conduct conduct) throws DatabaseException 
	{
		LOGGER.debug("Entry createConduct : conduct : " + conduct);
		try 
		{
			return jpaRepository.save(conduct);
		}
		catch (Exception e) 
		{
			throw new DatabaseException(DataConstants.DB_ERROR_CODE, e.getMessage(), e);
		}
		finally 
		{
			LOGGER.debug("Exit createConduct");
		}
	}

	@Override
	public Conduct getConduct(final Long conductId) throws DatabaseException 
	{
		LOGGER.debug("Entry getConduct : conductId : " + conductId);
		try 
		{
			return jpaRepository.findById(conductId).get();
		}
		catch (Exception e) 
		{
			throw new DatabaseException(DataConstants.DB_ERROR_CODE, e.getMessage(), e);
		}
		finally 
		{
			LOGGER.debug("Exit createConduct");	
		}
	}

	@Override
	public Conduct updateConduct(final Conduct conduct) throws DatabaseException 
	{
		LOGGER.debug("Entry updateConduct : conduct : " + conduct);
		try 
		{
			return jpaRepository.existsById(conduct.getId()) ? jpaRepository.save(conduct) : null;
		}
		catch (Exception e) 
		{
			throw new DatabaseException(DataConstants.DB_ERROR_CODE, e.getMessage(), e);
		}
		finally 
		{
			LOGGER.debug("Exit updateConduct");	
		}
	}

	@Override
	public Conduct deleteConduct(final Conduct conduct) throws DatabaseException 
	{
		LOGGER.debug("Entry deteleConduct : conduct : " + conduct);
		try 
		{
			return deleteConductById(conduct.getId());
		}
		catch (Exception e) 
		{
			throw new DatabaseException(DataConstants.DB_ERROR_CODE, e.getMessage(), e);
		}
		finally 
		{
			LOGGER.debug("Exit deleteConduct");	
		}
	}

	@Override
	public Conduct deleteConductById(final Long conductId) throws DatabaseException 
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
			throw new DatabaseException(DataConstants.DB_ERROR_CODE, e.getMessage(), e);
		}
		finally 
		{
			LOGGER.debug("Exit deleteConductById");	
		}
	}

	@Override
	public List<Conduct> getAllConduct() throws DatabaseException 
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
			throw new DatabaseException(DataConstants.DB_ERROR_CODE, e.getMessage(), e);
		}
		finally 
		{
			LOGGER.debug("Entry getAllConduct : list " + list);
		}
	}

	@Override
	public boolean loadDummyConducts(List<Conduct> conducts) throws DatabaseException 
	{
		LOGGER.debug("Entry createConduct : conduct : " + conducts);
		try 
		{
			jpaRepository.saveAll(conducts);
			return true;
		}
		catch (Exception e) 
		{
			throw new DatabaseException(DataConstants.DB_ERROR_CODE, e.getMessage(), e);
		}
		finally 
		{
			LOGGER.debug("Exit createConduct");
		}
		return false;
	}
}
