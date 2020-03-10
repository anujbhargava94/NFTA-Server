package com.nfta.stopsTransaction.daoImpl;

import java.util.List;

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

	@Override
	public List<StopTransactions> get(SearchFilters filters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StopTransactions> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(StopTransactions t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addOrUpdate(StopTransactions stopTransaction) {
		// TODO Auto-generated method stub
		em.persist(stopTransaction);
		return true;
	}

	@Override
	public boolean updateAdmin(StopTransactions stopTransaction) {
		// TODO Auto-generated method stub
		StopTransactions t =em.find(StopTransactions.class, stopTransaction.getTransaction_no());
		em.getTransaction().begin();
		t.setStatus(stopTransaction.getStatus());
		t.setStop_id(stopTransaction.getStop_id());
		t.setAdminComments(stopTransaction.getAdminComments());
		t.setAdditionalInformation(stopTransaction.getAdditionalInformation());
		em.getTransaction().commit();
		return true;
	}

}
