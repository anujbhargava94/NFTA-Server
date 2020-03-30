package com.nfta.stopsTransaction.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nfta.stopsTransaction.model.Route;
import com.nfta.stopsTransaction.model.RouteListed;
import com.nfta.stopsTransaction.model.SearchFilters;
import com.nfta.stopsTransaction.model.SearchFiltersRoutes;
import com.nfta.stopsTransaction.model.StopTransactions;

@Service
public interface RouteService {


	public String addRoute(Route route);

	
	public List<Route> getRoutes();
	
//	public List<RouteListed> getRoute(SearchFiltersRoutes searchFiltersRoutes);
}
