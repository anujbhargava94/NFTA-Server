package com.nfta.stopsTransaction.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.nfta.stopsTransaction.dao.TransactionsDao;
import com.nfta.stopsTransaction.model.SearchFilters;
import com.nfta.stopsTransaction.model.StopTransactions;
import com.nfta.stopsTransaction.service.TransactionService;

public class TransactionServiceImpl implements TransactionService{

	@Autowired
	TransactionsDao transactionsDao;
	
	@Override
	public StopTransactions getTransaction(SearchFilters searchFilters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addOrUpdate(StopTransactions stopTransaction) {
		// TODO Auto-generated method stub
		
		return transactionsDao.addOrUpdate(stopTransaction);
	}

	@Override
	public boolean updateAdmin(StopTransactions stopTransaction) {
		// TODO Auto-generated method stub
		return transactionsDao.updateAdmin(stopTransaction);
	}

}
