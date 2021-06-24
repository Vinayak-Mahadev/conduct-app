package com.datagrokr.integration.services.repo;

import java.util.List;

import com.datagrokr.common.exceptions.DatabaseException;
import com.datagrokr.integration.services.entities.Conduct;

public interface DatagrokrRepository 
{
	public Conduct createConduct(final Conduct conduct) throws DatabaseException;

	public Conduct getConduct(final Long conductId) throws DatabaseException;

	public Conduct updateConduct(final Conduct conduct) throws DatabaseException;

	public Conduct deleteConduct(final Conduct conduct) throws DatabaseException;

	public Conduct deleteConductById(final Long conductId) throws DatabaseException;

	public List<Conduct> getAllConduct() throws DatabaseException;

	public boolean loadDummyConducts(List<Conduct> conducts) throws DatabaseException;

}
