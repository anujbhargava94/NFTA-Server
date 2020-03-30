package com.nfta.stopsTransaction.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nfta.stopsTransaction.dao.RoutesDao;
import com.nfta.stopsTransaction.model.Route;
import com.nfta.stopsTransaction.model.RouteListed;
import com.nfta.stopsTransaction.model.SearchFiltersRoutes;
import com.nfta.stopsTransaction.model.StopTransactions;
import com.nfta.stopsTransaction.service.RouteService;

@Service
public class RouteServiceImpl implements RouteService{
	@Autowired
	RoutesDao routesDao;
	
	private static List<Route> routelist = new ArrayList<Route>();
	
	@Override
	public String addRoute(Route route) {
		// TODO Auto-generated method stub
		return routesDao.save(route);
	}

	@Override
	public List<Route> getRoutes() {
		// TODO Auto-generated method stub
		
		routelist = routesDao.getRoutes();
		return routelist;
	}
//
//	@Override
//	public List<RouteListed> getRoute(SearchFiltersRoutes searchFiltersRoutes) {
//		// TODO Auto-generated method stub
//		List<RouteListed> list = routesDao.getRoute(searchFiltersRoutes);
//		return list;
//	}
	
}
