package com.nfta.stopsTransaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nfta.stopsTransaction.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	TransactionService service;
//
//	@RequestMapping(value = "/transaction", method = RequestMethod.GET)
//	public @ResponseBody String getTransactions(@RequestParam("name") String stopName,
//			@RequestParam("id") String stopId, @RequestParam("location") String location,
//			@RequestParam("direction") String direction) {
//		
//		try {
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		Gson jsonString = new Gson();
//		return jsonString.toJson();
//	}
//
//	@RequestMapping(value = "/transactions", method = RequestMethod.GET)
//	public @ResponseBody ResponseEntity<List<StopTransactions>> getTransactions() {
//		List<StopTransactions> list;
//		try {
//			list= service.getAllTransactions();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return new ResponseEntity<List<StopTransactions>>(list, new HttpHeaders(), HttpStatus.OK);
//	}
//
//	/**
//	 * 
//	 * It can handle add and update both need to decide further on functionalities
//	 * 
//	 * @param stopTransaction
//	 * @return
//	 */
//	@RequestMapping(value = "/add", method = RequestMethod.POST)
//	public @ResponseBody String addTransaction(@RequestBody StopTransactions stopTransaction) {
//
//		try {
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		Gson jsonString = new Gson();
//		return jsonString.toJson();
//	}

}
