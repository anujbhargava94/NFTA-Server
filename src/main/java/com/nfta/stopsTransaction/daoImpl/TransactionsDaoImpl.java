package com.nfta.stopsTransaction.daoImpl;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nfta.stopsTransaction.dao.TransactionsDao;
import com.nfta.stopsTransaction.model.SearchFilters;
import com.nfta.stopsTransaction.model.StopTransactions;

@Component
@Service
@Transactional
public class TransactionsDaoImpl implements TransactionsDao{

	@PersistenceContext
	private EntityManager em;

	// SQL injection

	@Override
	public List<StopTransactions> get(SearchFilters filters) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<StopTransactions> cq = cb.createQuery(StopTransactions.class);

		Root<StopTransactions> stop = cq.from(StopTransactions.class);
		List<Predicate> predicates = new ArrayList<>();

		if (Objects.nonNull(filters.getCounty())) {
			predicates.add(cb.like(stop.get("county"), "%" + filters.getCounty() + "%"));
		}
		if (Objects.nonNull(filters.getDirection())) {
			predicates.add(cb.like(stop.get("direction"), "%" + filters.getDirection() + "%"));
		}
		if (Objects.nonNull(filters.getLocation())) {
			predicates.add(cb.like(stop.get("location"), "%" + filters.getLocation() + "%"));
		}
		if (Objects.nonNull(filters.getStopID())) {
			predicates.add(cb.equal(stop.get("stop_id"), filters.getStopID()));
		}
		if (Objects.nonNull(filters.getDateFrom())) {
			String dateFrom = filters.getDateFrom(); 
			String dateTo = filters.getDateTo();
			Timestamp dateTimeFrom=Timestamp.valueOf(dateFrom + " 00:00:00");  
			Timestamp dateTimeTo=Timestamp.valueOf(dateTo + " 23:59:59");
			predicates.add(cb.between(stop.get("create_date_time"), dateTimeFrom, dateTimeTo));
		}
		if (Objects.nonNull(filters.getStatus())) {
			predicates.add(cb.equal(stop.get("status"), filters.getStatus()));
		}
		if (Objects.nonNull(filters.getRequestType())) {
			predicates.add(cb.like(stop.get("request_type"), "%" + filters.getRequestType() + "%"));
		}
		if (Objects.nonNull(filters.getRequestID())) {
			predicates.add(cb.equal(stop.get("work_request").get("request_id"), filters.getRequestID()));
		}
		if (Objects.nonNull(filters.getTransaction_no())) {
			predicates.add(cb.equal(stop.get("transaction_no"), filters.getTransaction_no()));
		}
		
		cq.where(predicates.toArray(new Predicate[0]));
		cq.orderBy(cb.desc(stop.get("transaction_no")));

		return em.createQuery(cq).getResultList();

	}

	@Override
	public List<StopTransactions> getAll(String device) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<StopTransactions> cq = cb.createQuery(StopTransactions.class);
		Root<StopTransactions> stop = cq.from(StopTransactions.class);
		if(device!=null && !device.isEmpty()) {
			List<Predicate> predicates = new ArrayList<>();
			predicates.add(cb.like(stop.get("deviceName"), "%" +device + "%"));
			cq.where(predicates.toArray(new Predicate[0]));
		}
		cq.orderBy(cb.desc(stop.get("transaction_no")));
		CriteriaQuery<StopTransactions> all = cq.select(stop);
		TypedQuery<StopTransactions> allQuery;
		if(device!=null)
		{
			 allQuery = em.createQuery(all).setMaxResults(20);
		}else {
			allQuery = em.createQuery(all);
		}
		return allQuery.getResultList();
	}

	@Override
	public void delete(StopTransactions t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String addOrUpdate(StopTransactions stopTransaction) {
		// TODO Auto-generated method stub
		try
		{
			em.persist(stopTransaction);
		}
		catch(IllegalArgumentException e)
		{
			return "Illegal Argument";
		}
		return "";
	}
	
	@Transactional
	@Override
	public String update(StopTransactions stopTransaction) {
		// TODO Auto-generated method stub
		StopTransactions t =em.find(StopTransactions.class, stopTransaction.getTransaction_no());
		if(t==null)
		{
			return "No such transaction exists";
		}
	
		t.setStatus(stopTransaction.getStatus());
		t.setStop_id(stopTransaction.getStop_id());
		t.setAdmin_comments(stopTransaction.getAdmin_comments());
		t.setUser(stopTransaction.getUsername());
		t.setAdditional_information(stopTransaction.getAdditional_information());
		return "";
	}

}
