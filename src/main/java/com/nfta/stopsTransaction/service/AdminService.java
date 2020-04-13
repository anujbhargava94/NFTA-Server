package com.nfta.stopsTransaction.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nfta.stopsTransaction.model.AdminUser;

@Service
public interface AdminService {
	public String addUser(AdminUser adminUser);
	public void sendMail(String email_id); 
	public String findUser(AdminUser adminUser);
	public String getConfirmationToken();
	public List<AdminUser> confirmToken(String token);
	public String saveConfirmationToken(String username, String token);
	public String updatePassword(AdminUser adminUser);
	public String update(AdminUser adminUser);
	public String deleteUser(int user_id);
	public List<AdminUser> getAllUsers();
	public List<AdminUser>  getUser(int user_id);
}
