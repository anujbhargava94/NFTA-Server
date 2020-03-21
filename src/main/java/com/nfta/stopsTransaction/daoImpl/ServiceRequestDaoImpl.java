package com.nfta.stopsTransaction.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.nfta.stopsTransaction.dao.ServiceRequestDao;
import com.nfta.stopsTransaction.model.ServiceRequest;

@Service
@Transactional
public class ServiceRequestDaoImpl implements ServiceRequestDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public String save(ServiceRequest s) {
		try
		{
			em.persist(s);
		}
		catch(IllegalArgumentException e)
		{
			return "Illegal Argument";
		}
		return null;
	}

/*	@Override
	public void update(ServiceRequest s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ServiceRequest s) {
		// TODO Auto-generated method stub
		
	}
*/
	
}
