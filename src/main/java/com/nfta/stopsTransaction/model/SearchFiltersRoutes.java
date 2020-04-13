package com.nfta.stopsTransaction.model;

import org.springframework.stereotype.Component;

@Component
public class SearchFiltersRoutes {
	
	private StopTransactions stopTransactions;

	public StopTransactions getStopTransactions() {
		return stopTransactions;
	}

	public void setStopTransactions(StopTransactions stopTransactions) {
		this.stopTransactions = stopTransactions;
	}
	public void setSearchFilterRoutes(StopTransactions stopTransactions)
	{
		this.stopTransactions=stopTransactions;
	}

}
