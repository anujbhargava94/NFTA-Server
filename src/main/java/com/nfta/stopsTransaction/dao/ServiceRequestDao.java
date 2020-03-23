package com.nfta.stopsTransaction.dao;

import org.springframework.stereotype.Component;

import com.nfta.stopsTransaction.model.ServiceRequest;

@Component
public interface ServiceRequestDao {
    public String save(ServiceRequest s);
    //public void update(ServiceRequest s);
    //public void delete(ServiceRequest s);
}
