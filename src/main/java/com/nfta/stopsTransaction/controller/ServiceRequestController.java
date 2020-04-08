package com.nfta.stopsTransaction.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.nfta.stopsTransaction.model.SearchFilters;
import com.nfta.stopsTransaction.model.SearchFiltersServiceRequest;
import com.nfta.stopsTransaction.model.ServiceRequest;

import com.nfta.stopsTransaction.service.ServiceRequestService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins= {"https://web-nfta.herokuapp.com", "http://localhost:3000"})
public class ServiceRequestController {
	@Autowired
	ServiceRequestService serviceRequestService;
	
	@Autowired
	SearchFilters searchFilters;
	
	
	@RequestMapping(value = "/addServiceRequest", method = RequestMethod.POST)
	public @ResponseBody String addRequest(@RequestBody ServiceRequest serviceRequest) {
		String s = "";
		try {
			s = serviceRequestService.addServiceRequest(serviceRequest);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	
	@RequestMapping(value = "/serviceRequests", method = RequestMethod.GET)
	public @ResponseBody String getServiceRequests() {
		List<ServiceRequest> list = new ArrayList<>();
		try {
			list = serviceRequestService.getServiceRequests();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(list==null || list.size()==0)
		{
			return "";
		}
		Gson jsonString = new Gson();
		return jsonString.toJson(list);
		// return new ResponseEntity<List<StopTransactions>>(list, new HttpHeaders(),
		// HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/serviceRequest", method = RequestMethod.GET)
	public @ResponseBody String getServiceRequest(@RequestParam(value = "id", required = false) String requestId,
			@RequestParam(value = "stopID", required = false) String stopId,
			@RequestParam(value = "direction", required = false) String direction,
			@RequestParam(value = "datefrom", required = false) String dateFrom,
			@RequestParam(value = "dateto", required = false) String dateTo,
			@RequestParam(value = "type", required = false) String requestType,
			@RequestParam(value = "status", required = false) String status,
			@RequestParam(value = "adminUser", required = false) String adminUser) {
		List<ServiceRequest> list = new ArrayList<>();
		try {
			
			searchFilters.setSearchFilter(requestId, stopId, direction, dateFrom, dateTo, requestType, status, adminUser);
			list = serviceRequestService.getServiceRequest(searchFilters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(list==null || list.size()==0)
		{
			return "";
		}
		Gson jsonString = new Gson();
		return jsonString.toJson(list);
		// return new ResponseEntity<List<StopTransactions>>(list, new HttpHeaders(),
		// HttpStatus.OK);
	}
}
