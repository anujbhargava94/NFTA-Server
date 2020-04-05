package com.nfta.stopsTransaction.service;

import org.springframework.stereotype.Service;

import com.nfta.stopsTransaction.model.AdminUser;

@Service
public interface AdminService {
	public String addUser(AdminUser adminUser);
	public void sendMail(String email_id); 
	public String findUser(AdminUser adminUser);
	public String getConfirmationToken();
	public String confirmToken(String token);
	public String saveConfirmationToken(String username, String token);
	public String updatePassword(AdminUser adminUser);
	public String updateUserInfo(AdminUser adminUser);
}
