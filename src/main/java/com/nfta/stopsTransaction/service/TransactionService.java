package com.nfta.stopsTransaction.service;

import org.springframework.stereotype.Service;

import com.nfta.stopsTransaction.model.SearchFilters;
import com.nfta.stopsTransaction.model.StopTransactions;

@Service
public interface TransactionService {
	
	public StopTransactions getTransaction(SearchFilters searchFilters);

}
