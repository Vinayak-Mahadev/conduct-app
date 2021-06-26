package com.datagrokr.integration.services.repo;

import java.util.List;

import com.datagrokr.common.exceptions.RepositoryException;
import com.datagrokr.integration.services.entities.Conduct;

public interface DatagrokrRepository 
{
	public Conduct createConduct(final Conduct conduct) throws RepositoryException;

	public Conduct getConduct(final Long conductId) throws RepositoryException;

	public Conduct updateConduct(final Conduct conduct) throws RepositoryException;

	public Conduct deleteConduct(final Conduct conduct) throws RepositoryException;

	public Conduct deleteConductById(final Long conductId) throws RepositoryException;

	public List<Conduct> getAllConduct() throws RepositoryException;

	public List<Conduct> saveConducts(List<Conduct> conducts) throws RepositoryException;

	public boolean deleteAllConducts() throws RepositoryException;

	public long getConductsCount() throws RepositoryException;

}
