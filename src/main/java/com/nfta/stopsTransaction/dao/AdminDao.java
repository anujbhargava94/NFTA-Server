package com.nfta.stopsTransaction.dao;

import org.springframework.stereotype.Component;

import com.nfta.stopsTransaction.model.AdminUser;

@Component
public interface AdminDao {
	
	public String addUser(AdminUser adminUser);

	public boolean findUser(AdminUser adminUser);
	
	public String saveConfirmationToken(String email_id, String token);
	
	public String confirmToken(String token);
	
	public String updatePassword(AdminUser adminUser);
}
