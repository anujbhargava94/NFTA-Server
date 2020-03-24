package com.nfta.stopsTransaction.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nfta.stopsTransaction.dao.ServiceRequestDao;
import com.nfta.stopsTransaction.model.SearchFilters;
import com.nfta.stopsTransaction.model.SearchFiltersServiceRequest;
import com.nfta.stopsTransaction.model.ServiceRequest;
import com.nfta.stopsTransaction.service.ServiceRequestService;

public class ServiceRequestServiceImpl implements ServiceRequestService {
	@Autowired
	ServiceRequestDao serviceRequestDao;
	
	@Override
	public String addServiceRequest(ServiceRequest serviceRequest) {
		return serviceRequestDao.save(serviceRequest);
	}
	
	@Override
	public List<ServiceRequest> getServiceRequests(){
		List<ServiceRequest> list = serviceRequestDao.getServiceRequests();
		if(list==null || list.size()==0) {
			return null;
		}
		return list;
	}
	
	@Override
	public List<ServiceRequest> getServiceRequest(SearchFilters searchFilters) {

		List<ServiceRequest> list = serviceRequestDao.getServiceRequest(searchFilters);
		if(list==null || list.size()==0) {
			return null;
		}
		return list;
	}
}
