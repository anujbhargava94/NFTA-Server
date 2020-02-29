package com.nfta.stopsTransaction.service;

import com.nfta.stopsTransaction.model.SearchFilters;
import com.nfta.stopsTransaction.model.StopTransactions;

public interface TransactionService {
	
	public StopTransactions getTransaction(SearchFilters searchFilters);

}
