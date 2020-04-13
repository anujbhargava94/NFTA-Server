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
import com.nfta.stopsTransaction.model.SearchFilters;
import com.nfta.stopsTransaction.model.ServiceRequest;
import com.nfta.stopsTransaction.model.StopTransactions;

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
			em.flush();
			return s.getRequest_id().toString();
		}
		catch(IllegalArgumentException e)
		{
			return "Illegal Argument";
		}
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
	public List<ServiceRequest> getServiceRequest(SearchFilters filters) {
		// TODO Auto-generated method stub
		try
		{
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
			if (Objects.nonNull(filters.getRequestedUser())) {
				predicates.add(cb.like(servReq.get("requested_user"), "%" + filters.getRequestedUser() + "%"));
			}
			if (Objects.nonNull(filters.getStopID())) {
				predicates.add(cb.like(servReq.get("stop_id"), "%" + filters.getStopID() + "%"));
			}
			if (Objects.nonNull(filters.getDateFrom())) {
				predicates.add(cb.between(servReq.get("date_time"), filters.getDateFrom(), filters.getDateTo()));
			}
			if (Objects.nonNull(filters.getStatus())) {
				predicates.add(cb.like(servReq.get("status"), "%" + filters.getStatus() + "%"));
			}
			if (Objects.nonNull(filters.getRequestType())) {
				predicates.add(cb.like(servReq.get("request_type"), "%" + filters.getRequestType() + "%"));
			}
			cq.where(predicates.toArray(new Predicate[0]));
	
			return em.createQuery(cq).getResultList();
		}
		catch(Exception e) {
			return null;
		}
	}
	@Transactional
	@Override
	public String update(ServiceRequest serviceRequest) {
		// TODO Auto-generated method stub
		ServiceRequest t =em.find(ServiceRequest.class, serviceRequest.getRequest_id());
		if(t==null)
		{
			return "No such request exists";
		}
	
		t.setStatus(serviceRequest.getStatus());
		return "";
	}

	/*
	@Override
	public void delete(ServiceRequest s) {
		// TODO Auto-generated method stub
		
	}
*/
	
}
