package com.nfta.stopsTransaction.dao;

import org.springframework.stereotype.Component;

import com.nfta.stopsTransaction.model.AdminUser;


import java.util.List;


@Component
public interface AdminDao {

	public String addUser(AdminUser adminUser);
	public String deleteUser(int user_id);
	public List<AdminUser> getAllUsers();
	public List<AdminUser> getUser(int user_id);




}
