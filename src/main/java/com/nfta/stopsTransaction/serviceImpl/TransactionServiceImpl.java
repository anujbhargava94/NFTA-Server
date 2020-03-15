package com.nfta.stopsTransaction.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nfta.stopsTransaction.dao.TransactionsDao;
import com.nfta.stopsTransaction.model.SearchFilters;
import com.nfta.stopsTransaction.model.StopTransactions;
import com.nfta.stopsTransaction.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionsDao transactionsDao;

	@Override
	public List<StopTransactions> getTransactions(SearchFilters searchFilters) {

		List<StopTransactions> list = transactionsDao.get(searchFilters);
		return list;
	}

	
	@Override
	public List<StopTransactions> getAllTransactions() {
		List<StopTransactions> list = transactionsDao.getAll();
		return list;
	}

	@Override
	public boolean addOrUpdate(StopTransactions stopTransaction) {
		// TODO Auto-generated method stub
		
		return transactionsDao.addOrUpdate(stopTransaction);
	}

	@Override
	public boolean updateAdmin(StopTransactions stopTransaction) {
		// TODO Auto-generated method stub
		return transactionsDao.update(stopTransaction);
	}

}
