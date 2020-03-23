package com.nfta.stopsTransaction.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.nfta.stopsTransaction.dao.ServiceRequestDao;
import com.nfta.stopsTransaction.model.ServiceRequest;
import com.nfta.stopsTransaction.service.ServiceRequestService;

public class ServiceRequestServiceImpl implements ServiceRequestService {
	@Autowired
	ServiceRequestDao serviceRequestDao;
	
	@Override
	public String addServiceRequest(ServiceRequest serviceRequest) {
		return serviceRequestDao.save(serviceRequest);
	}
}
