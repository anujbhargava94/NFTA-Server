package com.nfta.stopsTransaction.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.nfta.stopsTransaction.model.AdminUser;
import com.nfta.stopsTransaction.model.StopTransactions;
import com.nfta.stopsTransaction.service.AdminService;


@RestController
@CrossOrigin(origins="http://localhost:3000")
//@CrossOrigin(origins="https://nfta-web.herokuapp.com")
public class UserController {
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public @ResponseBody String addUser(@RequestBody AdminUser adminUser) {

		String s="";
		try {
			s=adminService.addUser(adminUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	@RequestMapping(value = "/deleteUser/{user_id}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteUser(@PathVariable int user_id) {

		String s="";
		try {
			s=adminService.deleteUser(user_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public @ResponseBody String getUsers() {
		List<AdminUser> list = new ArrayList<>();
		try {
			list = adminService.getAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Gson jsonString = new Gson();
		return jsonString.toJson(list);
		// return new ResponseEntity<List<StopTransactions>>(list, new HttpHeaders(),
		// HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public @ResponseBody String updateInformation(@RequestBody AdminUser adminUser) {

		String s="";
		try {
			s=adminService.updateAdminInformation(adminUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	
	
	
	
//	Not in use
	@RequestMapping(value = "/user/{user_id}", method = RequestMethod.GET)
	public @ResponseBody String getUser(@RequestParam(value = "transaction_no", required = false) int user_id) {
		List<AdminUser> list = new ArrayList<>();
		try {
			list = adminService.getUser(user_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Gson jsonString = new Gson();
		return jsonString.toJson(list);
		// return new ResponseEntity<List<StopTransactions>>(list, new HttpHeaders(),
		// HttpStatus.OK);
	}
	
	

	
	

}
