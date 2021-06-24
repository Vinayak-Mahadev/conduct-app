package com.datagrokr.integration.services.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.datagrokr.common.exceptions.ApplicationException;
import com.datagrokr.integration.services.entities.Conduct;


@RequestMapping("/datagrokr/api")
public interface ConductsController 
{
	@RequestMapping(value = "/conduct/create",method = RequestMethod.POST, produces = {"application/json"})
	public Conduct createConduct(@RequestParam Conduct conduct) throws ApplicationException;

	@RequestMapping(value = "/conduct/{conductId}",method = RequestMethod.GET, produces = {"application/json"})
	public Conduct getConduct(@PathVariable Long conductId) throws ApplicationException;

	@RequestMapping(value = "/conduct/update",method = RequestMethod.PUT, produces = {"application/json"})
	public Conduct updateConduct(@RequestParam Conduct conduct) throws ApplicationException;

	@RequestMapping(value = "/conduct/delete",method = RequestMethod.DELETE, produces = {"application/json"})
	public Conduct deleteConduct(@RequestParam Conduct conduct) throws ApplicationException;

	@RequestMapping(value = "/conduct/delete/conductId",method = RequestMethod.DELETE, produces = {"application/json"})
	public Conduct deleteConductById(@RequestParam Long conductId) throws ApplicationException;

	@RequestMapping(value = "/conducts",method = RequestMethod.GET, produces = {"application/json"})
	public List<Conduct> getAllConduct() throws ApplicationException;

}
