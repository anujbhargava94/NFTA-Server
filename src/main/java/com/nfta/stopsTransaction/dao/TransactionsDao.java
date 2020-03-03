package com.nfta.stopsTransaction.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.nfta.stopsTransaction.model.SearchFilters;
import com.nfta.stopsTransaction.model.StopTransactions;

@Component
public interface TransactionsDao {
	
	public List<StopTransactions> get(SearchFilters filters);
    public List<StopTransactions> getAll();
    public int save(StopTransactions t);
    public void update(StopTransactions t);
    public void delete(StopTransactions t);
}
