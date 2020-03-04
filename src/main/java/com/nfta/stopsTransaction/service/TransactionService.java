package com.nfta.stopsTransaction.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nfta.stopsTransaction.model.SearchFilters;
import com.nfta.stopsTransaction.model.StopTransactions;

@Service
public interface TransactionService {
	
	public List<StopTransactions> getTransactions(SearchFilters searchFilters);

	public List<StopTransactions> getAllTransactions();

}
