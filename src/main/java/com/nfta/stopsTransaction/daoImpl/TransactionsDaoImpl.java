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

import org.springframework.stereotype.Component;

import com.nfta.stopsTransaction.dao.TransactionsDao;
import com.nfta.stopsTransaction.model.SearchFilters;
import com.nfta.stopsTransaction.model.StopTransactions;

@Component
public class TransactionsDaoImpl implements TransactionsDao {

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
			predicates.add(cb.like(stop.get("country"), "%" + filters.getCounty() + "%"));
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
			predicates.add(cb.between(stop.get("date_time"), filters.getDateFrom(), filters.getDateTo()));
		}
		if (Objects.nonNull(filters.getStatus())) {
			predicates.add(cb.equal(stop.get("status"), filters.getStatus()));
		}
		if (Objects.nonNull(filters.getRequestType())) {
			predicates.add(cb.equal(stop.get("request_type"), filters.getRequestType()));
		}
		cq.where(predicates.toArray(new Predicate[0]));

		return em.createQuery(cq).getResultList();

	}

	@Override
	public List<StopTransactions> getAll() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<StopTransactions> cq = cb.createQuery(StopTransactions.class);
		Root<StopTransactions> stop = cq.from(StopTransactions.class);
		CriteriaQuery<StopTransactions> all = cq.select(stop);
		TypedQuery<StopTransactions> allQuery = em.createQuery(all);
		return allQuery.getResultList();
		// return em.createQuery("SELECT r FROM StopTransactions r").getResultList();
	}

	@Override
	public int save(StopTransactions t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(StopTransactions t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(StopTransactions t) {
		// TODO Auto-generated method stub

	}

}
