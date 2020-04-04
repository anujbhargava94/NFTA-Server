package com.nfta.stopsTransaction.service;

import org.springframework.stereotype.Service;

import com.nfta.stopsTransaction.model.AdminUser;

@Service
@Deprecated
public interface AdminService {
	public String addUser(AdminUser adminUser);

}
