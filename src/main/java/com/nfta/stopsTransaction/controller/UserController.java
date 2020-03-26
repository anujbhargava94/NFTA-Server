package com.nfta.stopsTransaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nfta.stopsTransaction.model.AdminUser;
import com.nfta.stopsTransaction.service.AdminService;


@RestController
//@CrossOrigin(origins="http://localhost:3000")
@CrossOrigin(origins="https://nfta-web.herokuapp.com")
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
	
//	@RequestMapping(value = "/deleteUser/{user_id}", method = RequestMethod.DELETE)
//	public @ResponseBody String deleteUser(@PathVariable int user_id) {
//
//		String s="";
//		try {
//			s=adminService.addUser(adminUser);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return s;
//	}
	
	

	
	

}
