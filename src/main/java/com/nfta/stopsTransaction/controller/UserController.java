package com.nfta.stopsTransaction.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.nfta.stopsTransaction.config.JwtTokenUtil;
import com.nfta.stopsTransaction.config.JwtUserDetailsService;
import com.nfta.stopsTransaction.model.AdminUser;
import com.nfta.stopsTransaction.model.JwtRequest;
import com.nfta.stopsTransaction.model.JwtResponse;
import com.nfta.stopsTransaction.model.PingModel;
import com.nfta.stopsTransaction.model.UserDTO;
import com.nfta.stopsTransaction.service.AdminService;

@RestController
@CrossOrigin(origins = { "https://web-nfta.herokuapp.com", "http://localhost:3000" })

public class UserController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@Autowired
	AdminService adminService;
	
	@RequestMapping(value = "/user/delete/{user_id}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteUser(@PathVariable int user_id) {

		String s = "";
		try {
			s = adminService.deleteUser(user_id);
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

	@RequestMapping(value = "/user/forgotPassword", method = RequestMethod.POST)
	public @ResponseBody String findUser(@RequestBody AdminUser adminUser) {

		String s = "";
		try {
			s = adminService.findUser(adminUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	@RequestMapping(value = "/confirmreset", method = RequestMethod.POST)
	public @ResponseBody String verifyToken(@RequestBody AdminUser adminUser) {
		List<AdminUser> list = new ArrayList<>();
		try {
			list= adminService.confirmToken(adminUser.getReset_token());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Gson jsonString = new Gson();
		return jsonString.toJson(list);
	}

	@RequestMapping(value = "/user/update/password", method = RequestMethod.POST)
	public @ResponseBody String updatePassword(@RequestBody AdminUser adminUser) {

		String s = "";
		try {
			s = adminService.updatePassword(adminUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	@RequestMapping(value = "/user/update/details", method = RequestMethod.POST)
	public @ResponseBody void updateUser(@RequestBody AdminUser adminUser)throws Exception {

		String s = "";
		try {
			s = adminService.update(adminUser);
		} 
		catch(DataIntegrityViolationException e) {
			throw new Exception("UserName should be unique", e);
		} 
		catch (Exception e) {
			throw new Exception("Error occured", e);
		}

	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}
	
	@RequestMapping(value = "/registerDevice", method = RequestMethod.POST)
	public ResponseEntity<?> saveDevice(@RequestBody UserDTO user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public @ResponseBody String getAuthStatus() {
		PingModel ping = new PingModel();
		try {
			ping.setResult("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Gson jsonString = new Gson();
		return jsonString.toJson(ping);
		// return new ResponseEntity<List<StopTransactions>>(list, new HttpHeaders(),
		// HttpStatus.OK);
	}
}
