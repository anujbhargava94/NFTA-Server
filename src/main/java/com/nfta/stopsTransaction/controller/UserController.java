package com.nfta.stopsTransaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
	public @ResponseBody String findUser(@RequestBody AdminUser adminUser) {

		String s="";
		try {
			s=adminService.findUser(adminUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	@RequestMapping(value = "/confirm-reset", method = RequestMethod.GET)
	public @ResponseBody String verifyToken(String token) {

		String s="";
		try {
			s=adminService.confirmToken(token);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	public @ResponseBody String updatePassword(@RequestBody AdminUser adminUser, String password) {

		String s="";
		try {
			s=adminService.updatePassword(adminUser,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

}
