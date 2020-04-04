package com.nfta.stopsTransaction.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nfta.stopsTransaction.dao.AdminDao;
import com.nfta.stopsTransaction.model.AdminUser;

@Component
@Service
@Transactional
@Deprecated
public class AdminDaoImpl implements AdminDao{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public String addUser(AdminUser adminUser) {
		// TODO Auto-generated method stub
		try
		{
			em.persist(adminUser);
		}
		catch(IllegalArgumentException e)
		{
			return "Illegal Argument";
		}
		return "";
	}

}
