package com.nfta.stopsTransaction.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
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
	public boolean save(Route t) {
		// TODO Auto-generated method stub
		em.persist(t);
		return true;
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
