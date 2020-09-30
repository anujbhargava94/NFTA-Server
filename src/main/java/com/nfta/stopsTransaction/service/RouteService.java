package com.nfta.stopsTransaction.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nfta.stopsTransaction.model.Route;

@Service
public interface RouteService {


	public String addRoute(Route route);

	
	public List<Route> getRoutes();
	
}
