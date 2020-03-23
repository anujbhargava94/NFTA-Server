package com.nfta.stopsTransaction.daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.nfta.stopsTransaction.dao.ServiceRequestDao;
import com.nfta.stopsTransaction.model.SearchFiltersServiceRequest;
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

	@Override
	public List<ServiceRequest> getServiceRequests() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ServiceRequest> cq = cb.createQuery(ServiceRequest.class);
		Root<ServiceRequest> stop = cq.from(ServiceRequest.class);
		CriteriaQuery<ServiceRequest> all = cq.select(stop);
		TypedQuery<ServiceRequest> allQuery = em.createQuery(all);
		return allQuery.getResultList();
		// return em.createQuery("SELECT r FROM StopTransactions r").getResultList();
	}
	
	@Override
	public List<ServiceRequest> get(SearchFiltersServiceRequest filters) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ServiceRequest> cq = cb.createQuery(ServiceRequest.class);

		Root<ServiceRequest> servReq = cq.from(ServiceRequest.class);
		List<Predicate> predicates = new ArrayList<>();

		if (Objects.nonNull(filters.getRequestID())) {
			predicates.add(cb.equal(servReq.get("request_id"), filters.getRequestID()));
		}
		if (Objects.nonNull(filters.getDirection())) {
			predicates.add(cb.like(servReq.get("direction"), "%" + filters.getDirection() + "%"));
		}
		if (Objects.nonNull(filters.getAdminUser())) {
			predicates.add(cb.like(servReq.get("admin_user_id"), "%" + filters.getAdminUser() + "%"));
		}
		if (Objects.nonNull(filters.getStopID())) {
			predicates.add(cb.equal(servReq.get("stop_id"), filters.getStopID()));
		}
		if (Objects.nonNull(filters.getDateFrom())) {
			predicates.add(cb.between(servReq.get("date_time"), filters.getDateFrom(), filters.getDateTo()));
		}
		if (Objects.nonNull(filters.getStatus())) {
			predicates.add(cb.equal(servReq.get("status"), filters.getStatus()));
		}
		if (Objects.nonNull(filters.getRequestType())) {
			predicates.add(cb.equal(servReq.get("request_type"), filters.getRequestType()));
		}
		cq.where(predicates.toArray(new Predicate[0]));

		return em.createQuery(cq).getResultList();

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
