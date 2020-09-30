package com.nfta.stopsTransaction.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.nfta.stopsTransaction.model.Dropdowns;
import com.nfta.stopsTransaction.model.StopTransactions;
import com.nfta.stopsTransaction.service.DropdownService;

@RestController
@RequestMapping("/")

@CrossOrigin(origins= {"https://web-nfta.herokuapp.com", "http://localhost:3000"})
public class DropdownController {
	@Autowired
	DropdownService dropdownService;

	@RequestMapping(value = "/dropdown", method = RequestMethod.GET)
	public @ResponseBody String getDropdowns(@RequestParam(value = "dropdownType", required = false) String dropdownType) {
		List<Dropdowns> dropdownlist = new ArrayList<>();
		try {
			dropdownlist = dropdownService.getDropdowns(dropdownType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Gson jsonString = new Gson();
		return jsonString.toJson(dropdownlist);
	}
	
	@RequestMapping(value = "/addDropdown", method = RequestMethod.POST)
	public @ResponseBody void addDropdown(@RequestBody Dropdowns dropdown) throws Exception {
		String s="";
		try {
			s=dropdownService.addDropdown(dropdown);
		}catch(DataIntegrityViolationException e) {
			throw new Exception("Id and Info should be unique", e);
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Some error occured", e);
		}

	}
	
	@RequestMapping(value = "/deleteDropdown", method = RequestMethod.POST)
	public @ResponseBody String deleteDropdown(@RequestBody Dropdowns dropdown) {
		String s="";
		try {
			s=dropdownService.deleteDropdown(dropdown);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
}

