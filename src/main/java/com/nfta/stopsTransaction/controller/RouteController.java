package com.nfta.stopsTransaction.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.nfta.stopsTransaction.service.*;
import com.nfta.stopsTransaction.model.Route;


@RestController
@RequestMapping("/")
public class RouteController {
	@Autowired
	RouteService routeService;
	
	@RequestMapping(value = "/routes", method = RequestMethod.GET)
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
	
	@RequestMapping(value = "/addroute", method = RequestMethod.POST)
	public @ResponseBody String addRoute(@RequestBody Route route) {

		try {
			routeService.addRoute(route);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
