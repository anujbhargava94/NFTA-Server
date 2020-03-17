package com.nfta.stopsTransaction.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.nfta.stopsTransaction.model.SearchFilters;
import com.nfta.stopsTransaction.model.StopTransactions;
import com.nfta.stopsTransaction.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	TransactionService service;

	@Autowired
	SearchFilters searchFilters;

	@RequestMapping(value = "/transaction", method = RequestMethod.GET)
	public @ResponseBody String getTransactions(@RequestParam(value = "id", required = false) String stopId,
			@RequestParam(value = "location", required = false) String location,
			@RequestParam(value = "direction", required = false) String direction,
			@RequestParam(value = "country", required = false) String country,
			@RequestParam(value = "datefrom", required = false) String dateFrom,
			@RequestParam(value = "dateto", required = false) String dateTo,
			@RequestParam(value = "type", required = false) String requestType,
			@RequestParam(value = "status", required = false) String status) {
		List<StopTransactions> list = new ArrayList<>();
		try {

			setSearchFilter(stopId, location, direction, country, dateFrom, dateTo, requestType, status);
			list = service.getTransactions(searchFilters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Gson jsonString = new Gson();
		return jsonString.toJson(list);
		// return new ResponseEntity<List<StopTransactions>>(list, new HttpHeaders(),
		// HttpStatus.OK);
	}

	@RequestMapping(value = "/transactions", method = RequestMethod.GET)
	public @ResponseBody String getTransactions() {
		List<StopTransactions> list = new ArrayList<>();
		try {
			list = service.getAllTransactions();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Gson jsonString = new Gson();
		return jsonString.toJson(list);
		// return new ResponseEntity<List<StopTransactions>>(list, new HttpHeaders(),
		// HttpStatus.OK);
	}

	/**
	 * 
	 * It can handle add and update both need to decide further on functionalities
	 * 
	 * @param stopTransaction
	 * @return
	 */
	
	private void setSearchFilter(String stopId, String location, String direction, String country, String dateFrom,
			String dateTo, String requestType, String status) {
		searchFilters.setCounty(country);
		searchFilters.setDateFrom(dateFrom);
		searchFilters.setDateTo(dateTo);
		searchFilters.setDirection(direction);
		searchFilters.setLocation(location);
		searchFilters.setStopID(stopId);
		searchFilters.setStatus(status);
		searchFilters.setRequestType(requestType);
	}

	/**
	 * 
	 * It can handle add and update both need to decide further on functionalities
	 * 
	 * @param stopTransaction
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody String addTransaction(@RequestBody StopTransactions stopTransaction) {
		String s="";
		try {
			s=service.addOrUpdate(stopTransaction);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody String updateTransaction(@RequestBody StopTransactions stopTransaction) {

		String s="";
		try {
			s=service.addOrUpdate(stopTransaction);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	@RequestMapping(value = "/updateTransaction", method = RequestMethod.POST)
	public @ResponseBody String updateInformation(@RequestBody StopTransactions stopTransaction) {

		String s="";
		try {
			s=service.updateStopsInformation(stopTransaction);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
}
