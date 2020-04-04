package com.nfta.stopsTransaction.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nfta.stopsTransaction.dao.AdminDao;
import com.nfta.stopsTransaction.model.AdminUser;
import com.nfta.stopsTransaction.service.AdminService;


@Service
@Component
@Transactional
@Deprecated
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminDao adminDao;

	@Override
	public String addUser(AdminUser adminUser) {
		// TODO Auto-generated method stub
		return adminDao.addUser(adminUser);
	}



}
