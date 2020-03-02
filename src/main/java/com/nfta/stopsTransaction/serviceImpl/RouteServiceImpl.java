package com.nfta.stopsTransaction.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.nfta.stopsTransaction.dao.RoutesDao;
import com.nfta.stopsTransaction.model.Route;
import com.nfta.stopsTransaction.service.RouteService;

public class RouteServiceImpl implements RouteService{
	@Autowired
	RoutesDao routesDao;
	
	private static List<Route> routelist = new ArrayList<Route>();
	
	@Override
	public void addRoute(Route route) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Route> getRoutes() {
		// TODO Auto-generated method stub
		routelist = routesDao.getRoutes();
		return routelist;
	}
	
}
