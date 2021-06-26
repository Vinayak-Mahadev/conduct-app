package com.datagrokr.integration.services.bean;

import java.io.Serializable;

import com.datagrokr.integration.services.entities.Conduct;

public class ServiceBean implements Serializable 
{
	private static final long serialVersionUID = 1L;

	private Conduct requestConduct;

	private Conduct responseConduct;

	private String message;

	private Long status;
	
	private Long requestId;

	private String request;

	private String response;

	private String requestTemplate;

	public Conduct getRequestConduct() {
		return requestConduct;
	}

	public void setRequestConduct(Conduct conduct) {
		this.requestConduct = conduct;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getRequestTemplate() {
		return requestTemplate;
	}

	public void setRequestTemplate(String requestTemplate) {
		this.requestTemplate = requestTemplate;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Conduct getResponseConduct() {
		return responseConduct;
	}

	public void setResponseConduct(Conduct responseConduct) {
		this.responseConduct = responseConduct;
	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}
	
}
