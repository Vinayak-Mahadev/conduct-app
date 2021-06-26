package com.datagrokr.integration.services.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.datagrokr.common.exceptions.ApplicationException;
import com.datagrokr.integration.services.entities.Conduct;


@RequestMapping("/datagrokr/ui/api")
@CrossOrigin
public interface UiConductController
{
	@RequestMapping(value = "/conducts", method = RequestMethod.GET)
	public List<Conduct> getAllConduct() throws ApplicationException;

	@RequestMapping(value = "/conducts/{id}",method = RequestMethod.GET)
	public ResponseEntity<Conduct> getConduct(@PathVariable(value = "id") Long conductId) throws ApplicationException;

	@RequestMapping(value = "/conducts", method = RequestMethod.POST)
	public Conduct createConduct(@RequestBody Conduct conduct) throws ApplicationException;

	@RequestMapping(value = "/conducts/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Conduct> updateConduct(@PathVariable(value = "id") Long conductId, @Valid @RequestBody Conduct conduct) throws ApplicationException;
	
	@RequestMapping(value = "/conducts/{conductId}",method = RequestMethod.DELETE)
	public Map<String, Boolean> deleteConduct(@PathVariable Long conductId) throws ApplicationException;
	
}
