package com.nfta.stopsTransaction.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.google.gson.Gson;
import com.nfta.stopsTransaction.model.Route;
import com.nfta.stopsTransaction.service.RouteService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins= {"https://web-nfta.herokuapp.com", "http://localhost:3000"})
public class RouteController {
	@Autowired
	RouteService routeService;

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

}
