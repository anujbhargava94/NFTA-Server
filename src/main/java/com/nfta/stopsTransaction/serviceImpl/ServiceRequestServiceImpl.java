package com.nfta.stopsTransaction.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nfta.stopsTransaction.dao.ServiceRequestDao;
import com.nfta.stopsTransaction.model.Dropdowns;
import com.nfta.stopsTransaction.model.SearchFilters;
import com.nfta.stopsTransaction.model.ServiceRequest;
import com.nfta.stopsTransaction.model.StopTransactions;
import com.nfta.stopsTransaction.service.ServiceRequestService;

public class ServiceRequestServiceImpl implements ServiceRequestService {
	@Autowired
	ServiceRequestDao serviceRequestDao;
	
	@Override
	public String addServiceRequest(ServiceRequest serviceRequest) {
		consolidateDropDowns(serviceRequest);
		return serviceRequestDao.save(serviceRequest);
	}
	
	@Override
	public List<ServiceRequest> getServiceRequests(){
		List<ServiceRequest> list = serviceRequestDao.getServiceRequests();
		if (list != null && !list.isEmpty()) {
			for (ServiceRequest serviceRequest : list) {
				setRespectiveDropDowns(serviceRequest);
			}
		}
		return list;
	}
	
	@Override
	public List<ServiceRequest> getServiceRequest(SearchFilters searchFilters) {

		List<ServiceRequest> list = serviceRequestDao.getServiceRequest(searchFilters);
		if (list != null && !list.isEmpty()) {
			for (ServiceRequest serviceRequest : list) {
				setRespectiveDropDowns(serviceRequest);
			}
		}
		return list;
	}
	
	private void consolidateDropDowns(ServiceRequest serviceRequest) {
		// TODO Auto-generated method stub
		if (serviceRequest != null 
				&& (serviceRequest.getDropdowns() == null || serviceRequest.getDropdowns().isEmpty())) {
			List<Dropdowns> dropDowns = new ArrayList<>();
			if (serviceRequest.getRoute() != null) {
				dropDowns.addAll(serviceRequest.getRoute());
				serviceRequest.setRoute(null);
			}  if (serviceRequest.getDirection() != null) {
				dropDowns.add(serviceRequest.getDirection());
				serviceRequest.setDirection(null);
			}  
			serviceRequest.setDropdowns(dropDowns);
		}

	}
	
	private void setRespectiveDropDowns(ServiceRequest serviceRequest) {
		if (serviceRequest != null && serviceRequest.getDropdowns() != null && !serviceRequest.getDropdowns().isEmpty()) {
			List<Dropdowns> dropDowns = serviceRequest.getDropdowns();
			List<Dropdowns> routes = new ArrayList<>();
			for (Dropdowns element : dropDowns) {
				if (element.getDropdown_type().equals("route")) {
					routes.add(element);
				} else if (element.getDropdown_type().equals("direction")) {
					serviceRequest.setDirection(element);
				}
			}
			serviceRequest.setRoute(routes);

		}

	}
	
	@Override
	public String updateServiceRequest(ServiceRequest serviceRequest) {
		// TODO Auto-generated method stub
		return serviceRequestDao.update(serviceRequest);
	}
}
