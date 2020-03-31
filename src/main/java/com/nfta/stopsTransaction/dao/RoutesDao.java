package com.nfta.stopsTransaction.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.nfta.stopsTransaction.model.Route;
import com.nfta.stopsTransaction.model.RouteListed;
import com.nfta.stopsTransaction.model.SearchFiltersRoutes;

@Component
public interface RoutesDao {
	public List<Route> getRoutes();
//	public List<RouteListed> getRoute(SearchFiltersRoutes searchFiltersRoutes);
    public String save(Route t);
    public void update(Route t);
    public void delete(Route t);
}
