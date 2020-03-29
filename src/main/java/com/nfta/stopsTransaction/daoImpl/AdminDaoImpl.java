package com.nfta.stopsTransaction.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nfta.stopsTransaction.dao.AdminDao;
import com.nfta.stopsTransaction.model.AdminUser;
import com.nfta.stopsTransaction.model.ServiceRequest;

@Component
@Service
@Transactional
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

	@Override
	public boolean findUser(AdminUser adminUser) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<AdminUser> cq = cb.createQuery(AdminUser.class);

		Root<AdminUser> userReq = cq.from(AdminUser.class);
		if(cb.equal(userReq.get("email_id"), adminUser.getEmail_id()) != null)
			return true;
		return false;
	}

}

