package com.nfta.stopsTransaction.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nfta.stopsTransaction.model.AdminUser;

@Service
public interface AdminService {
	public String addUser(AdminUser adminUser);
	public String deleteUser(int user_id);
	public List<AdminUser> getAllUsers();
	public List<AdminUser>  getUser(int user_id);


}
