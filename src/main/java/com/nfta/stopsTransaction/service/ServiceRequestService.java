package com.nfta.stopsTransaction.service;

import java.util.List;

import com.nfta.stopsTransaction.model.SearchFilters;
import com.nfta.stopsTransaction.model.SearchFiltersServiceRequest;
import com.nfta.stopsTransaction.model.ServiceRequest;


public interface ServiceRequestService {
	public String addServiceRequest(ServiceRequest serviceRequest);
	public List<ServiceRequest> getServiceRequests();
	public List<ServiceRequest> getServiceRequest(SearchFilters searchFilters);
}
