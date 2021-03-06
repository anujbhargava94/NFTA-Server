package com.nfta.stopsTransaction.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.nfta.stopsTransaction.model.AdminUser;
import com.nfta.stopsTransaction.model.SearchFilters;
import com.nfta.stopsTransaction.model.StopTransactions;
import com.nfta.stopsTransaction.service.TransactionService;

@RestController
@CrossOrigin(origins= {"https://web-nfta.herokuapp.com", "http://localhost:3000"})
public class TransactionController {

	@Autowired
	TransactionService service;

	@Autowired
	SearchFilters searchFilters;

	@RequestMapping(value = "/transaction", method = RequestMethod.GET)
	public @ResponseBody String getTransactions(
			@RequestParam(value = "transaction_no", required = false) Long transaction_no,
			@RequestParam(value = "id", required = false) String stopId,
			@RequestParam(value = "location", required = false) String location,
			@RequestParam(value = "direction", required = false) String direction,
			@RequestParam(value = "country", required = false) String country,
			@RequestParam(value = "datefrom", required = false) String dateFrom,
			@RequestParam(value = "dateto", required = false) String dateTo,
			@RequestParam(value = "type", required = false) String requestType,
			@RequestParam(value = "requestID", required = false) String requestId,
			@RequestParam(value = "status", required = false) String status) {
		List<StopTransactions> list = new ArrayList<>();
		try {

			searchFilters.setSearchFilter(transaction_no,stopId, location, direction, country, dateFrom, dateTo, requestType, requestId, status);
			list = service.getTransactions(searchFilters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Gson jsonString = new Gson();
		return jsonString.toJson(list);
		// return new ResponseEntity<List<StopTransactions>>(list, new HttpHeaders(),
		// HttpStatus.OK);
	}
    
	//@CrossOrigin(origins="http://localhost:3000")
	@RequestMapping(value = "/transactions", method = RequestMethod.GET)
	public @ResponseBody String getTransactions(@RequestHeader("device") String device) {
		List<StopTransactions> list = new ArrayList<>();
		try {
			list = service.getAllTransactions(device);
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
	 * @param transaction_no 
	 * 
	 * @param stopTransaction
	 * @return
	 */
	

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
