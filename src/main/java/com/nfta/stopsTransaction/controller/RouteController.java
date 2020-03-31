package com.nfta.stopsTransaction.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.nfta.stopsTransaction.service.*;
import com.nfta.stopsTransaction.model.Route;
import com.nfta.stopsTransaction.model.RouteListed;
import com.nfta.stopsTransaction.model.SearchFiltersRoutes;
import com.nfta.stopsTransaction.model.ServiceRequest;
import com.nfta.stopsTransaction.model.StopTransactions;


@RestController
@RequestMapping("/")
@CrossOrigin(origins="http://localhost:3000")
//@CrossOrigin(origins="https://nfta-web.herokuapp.com")
public class RouteController {
	@Autowired
	RouteService routeService;
	
	@Autowired
	SearchFiltersRoutes searchFiltersRoutes;
	
	@RequestMapping(value = "routes", method = RequestMethod.GET)
	public @ResponseBody String getRoutes() {
			List<Route> routelist = new ArrayList<>();
		try {
			routelist = routeService.getRoutes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Gson jsonString = new Gson();
		return jsonString.toJson(routelist);
	}
	
	@RequestMapping(value = "route/add", method = RequestMethod.POST)
	public @ResponseBody String addRoute(@RequestBody Route route) {
		String s = "";
		try {
			s = routeService.addRoute(route);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	
//	@RequestMapping(value = "routesList", method = RequestMethod.GET)
//	public @ResponseBody String getRoute(
//			@RequestParam(value = "stopTransactions", required = false) StopTransactions stopTransactions) {
//		List<RouteListed> list = new ArrayList<>();
//		try {
//			
//			searchFiltersRoutes.setSearchFilterRoutes(stopTransactions);
//			list = routeService.getRoute(searchFiltersRoutes);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		if(list==null || list.size()==0)
//		{
//			return "";
//		}
//		Gson jsonString = new Gson();
//		return jsonString.toJson(list);}

}
