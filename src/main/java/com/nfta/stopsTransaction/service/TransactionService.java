package com.nfta.stopsTransaction.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nfta.stopsTransaction.model.AdminUser;
import com.nfta.stopsTransaction.model.SearchFilters;
import com.nfta.stopsTransaction.model.StopTransactions;

@Service
public interface TransactionService {
	
	public String addOrUpdate(StopTransactions stopTransaction);
	public String updateStopsInformation(StopTransactions stopTransaction);
	
	public List<StopTransactions> getTransactions(SearchFilters searchFilters);

	public List<StopTransactions> getAllTransactions();

}
