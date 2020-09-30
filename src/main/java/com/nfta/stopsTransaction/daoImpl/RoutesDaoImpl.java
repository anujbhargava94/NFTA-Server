package com.nfta.stopsTransaction.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.nfta.stopsTransaction.dao.RoutesDao;
import com.nfta.stopsTransaction.model.Route;


@Service
@Transactional
public class RoutesDaoImpl implements RoutesDao{
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Route> getRoutes() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT r FROM Route r").getResultList();
	}

	@Override
	public String save(Route t) {
		// TODO Auto-generated method stub
		try
		{
			em.persist(t);
		}
		catch(IllegalArgumentException e)
		{
			return "Illegal Argument";
		}
		catch(Exception e)
		{
			return "Exception occurred";
		}
		return "";
	}

	@Override
	public void update(Route t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Route t) {
		// TODO Auto-generated method stub
		
	}

}
