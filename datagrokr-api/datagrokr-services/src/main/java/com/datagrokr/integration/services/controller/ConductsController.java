package com.datagrokr.integration.services.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.datagrokr.common.exceptions.ApplicationException;

//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/datagrokr/api")
public interface ConductsController 
{
	@RequestMapping(value = "/conduct/create", method = RequestMethod.POST)
	public String createConduct(@RequestBody String requestData) throws ApplicationException;

	@RequestMapping(value = "/conduct/{conductId}",method = RequestMethod.GET)
	public String getConduct(@PathVariable Long conductId) throws ApplicationException;

	@RequestMapping(value = "/conduct/update",method = RequestMethod.PUT)
	public String updateConduct(@RequestBody String conduct) throws ApplicationException;
	
	@RequestMapping(value = "/conduct/delete/{conductId}",method = RequestMethod.DELETE)
	public String deleteConduct(@PathVariable Long conductId) throws ApplicationException;

	@RequestMapping(value = "/conducts",method = RequestMethod.GET)
	public String getAllConduct() throws ApplicationException;

	@RequestMapping(value = "/conduct/loaddummyData",method = RequestMethod.GET)
	public String loaddummyData() throws ApplicationException;

	@RequestMapping(value = "/conduct/resetConducts",method = RequestMethod.DELETE)
	public String resetConducts() throws ApplicationException;

}
