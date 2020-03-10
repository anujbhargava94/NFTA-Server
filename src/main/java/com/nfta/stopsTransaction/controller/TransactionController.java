package com.nfta.stopsTransaction.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import com.nfta.stopsTransaction.model.SearchFilters;

import com.nfta.stopsTransaction.model.StopTransactions;

@RestController
public class TransactionController {

//	@RequestMapping(value = "/transaction", method = RequestMethod.GET)
//	public @ResponseBody String getTransactions(@RequestParam("name") String stopName,
//			@RequestParam("id") String stopId, @RequestParam("location") String location,
//			@RequestParam("direction") String direction) {
//
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
//	public @ResponseBody String getTransactions() {
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
