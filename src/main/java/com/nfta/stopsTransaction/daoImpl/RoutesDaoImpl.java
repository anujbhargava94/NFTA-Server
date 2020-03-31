package com.nfta.stopsTransaction.daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nfta.stopsTransaction.dao.RoutesDao;
import com.nfta.stopsTransaction.model.Route;
import com.nfta.stopsTransaction.model.RouteListed;
import com.nfta.stopsTransaction.model.SearchFiltersRoutes;
import com.nfta.stopsTransaction.model.ServiceRequest;


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

//	@Override
//	public List<RouteListed> getRoute(SearchFiltersRoutes searchFiltersRoutes) {
//		// TODO Auto-generated method stub
//		
//		try {
//			CriteriaBuilder cb = em.getCriteriaBuilder();
//			CriteriaQuery<RouteListed> cq = cb.createQuery(RouteListed.class);
//			
//			Root<RouteListed> routeList = cq.from(RouteListed.class);
//			List<Predicate> predicates = new ArrayList<>();
//	
//			if (Objects.nonNull(searchFiltersRoutes.getStopTransactions())) {
//				predicates.add(cb.equal(routeList.get("stopTransactions"), searchFiltersRoutes.getStopTransactions()));
//			}
//			cq.where(predicates.toArray(new Predicate[0]));
//			
//			return em.createQuery(cq).getResultList();
//			
//		} catch (Exception e) {
//			return null;
//			// TODO: handle exception
//		}
//		
//			}

}
