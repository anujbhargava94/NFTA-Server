package com.nfta.stopsTransaction.service;

import org.springframework.stereotype.Service;

import com.nfta.stopsTransaction.model.AdminUser;

@Service
public interface AdminService {
	public String addUser(AdminUser adminUser);
	public void sendMail(String email_id); 
	public String findUser(AdminUser adminUser);
}
