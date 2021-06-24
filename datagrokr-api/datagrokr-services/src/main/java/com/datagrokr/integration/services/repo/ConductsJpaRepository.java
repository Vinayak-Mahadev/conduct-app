package com.datagrokr.integration.services.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.datagrokr.integration.services.entities.Conduct;

@Repository
public interface ConductsJpaRepository extends CrudRepository<Conduct, Long>
{
}
