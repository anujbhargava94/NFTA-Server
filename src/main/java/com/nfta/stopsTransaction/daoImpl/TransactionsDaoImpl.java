package com.nfta.stopsTransaction.daoImpl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.nfta.stopsTransaction.dao.TransactionsDao;
import com.nfta.stopsTransaction.model.SearchFilters;
import com.nfta.stopsTransaction.model.StopTransactions;

@Component
public class TransactionsDaoImpl implements TransactionsDao{

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
