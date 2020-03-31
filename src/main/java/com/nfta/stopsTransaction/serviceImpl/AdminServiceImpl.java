package com.nfta.stopsTransaction.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nfta.stopsTransaction.dao.AdminDao;
import com.nfta.stopsTransaction.model.AdminUser;
import com.nfta.stopsTransaction.service.AdminService;

import java.util.List;


@Service
@Component
@Transactional
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminDao adminDao;

	@Override
	public String addUser(AdminUser adminUser) {
		// TODO Auto-generated method stub
		return adminDao.addUser(adminUser);
	}

	@Override
	public String deleteUser(int user_id) {
		// TODO Auto-generated method stub
		return adminDao.deleteUser(user_id);

	}

	@Override
	public List<AdminUser> getAllUsers() {
		// TODO Auto-generated method stub
		return adminDao.getAllUsers();
	}

	@Override
	public List<AdminUser>  getUser(int user_id) {
		// TODO Auto-generated method stub
		return adminDao.getUser(user_id);
	}

	@Override
	public String updateAdminInformation(AdminUser adminUser) {
		// TODO Auto-generated method stub
		return adminDao.update(adminUser);
	}



}
