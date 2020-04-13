package com.nfta.stopsTransaction.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.nfta.stopsTransaction.model.SearchFilters;
import com.nfta.stopsTransaction.model.ServiceRequest;

@Component
public interface ServiceRequestDao {
    public String save(ServiceRequest s);
    public List<ServiceRequest> getServiceRequests();
    public List<ServiceRequest> getServiceRequest(SearchFilters filters);
    //public void update(ServiceRequest s);
    //public void delete(ServiceRequest s);
}
