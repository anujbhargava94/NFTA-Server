package com.nfta.stopsTransaction.dao;

import org.springframework.stereotype.Component;

import com.nfta.stopsTransaction.model.AdminUser;

@Component
@Deprecated
public interface AdminDao {
	
	
	

	public String addUser(AdminUser adminUser);


}
