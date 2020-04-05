package com.nfta.stopsTransaction.dao;

import org.springframework.stereotype.Component;

import com.nfta.stopsTransaction.model.AdminUser;

@Component
public interface AdminDao {
	
	public String addUser(AdminUser adminUser);

	public boolean findUser(AdminUser adminUser);
	
	public String saveConfirmationToken(String username, String token);
	
	public String confirmToken(String token);
	
	public String updatePassword(AdminUser adminUser);
	
	public String updateUserInfo(AdminUser adminUser);
}
