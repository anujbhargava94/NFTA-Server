package com.nfta.stopsTransaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nfta.stopsTransaction.model.ServiceRequest;
import com.nfta.stopsTransaction.service.ServiceRequestService;

@RestController
@RequestMapping("/")
public class ServiceRequestController {
	@Autowired
	ServiceRequestService serviceRequestService;
	
	
	@RequestMapping(value = "request", method = RequestMethod.POST)
	public @ResponseBody String addRequest(@RequestBody ServiceRequest serviceRequest) {
		String s = "";
		try {
			s = serviceRequestService.addServiceRequest(serviceRequest);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
}
