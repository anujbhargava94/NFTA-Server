package com.nfta.stopsTransaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.nfta.stopsTransaction.model.AdminUser;
import com.nfta.stopsTransaction.model.LoginResponse;
import com.nfta.stopsTransaction.model.User;
import com.nfta.stopsTransaction.service.AdminService;
import com.nfta.stopsTransaction.service.SecurityService;
import com.nfta.stopsTransaction.service.UserService;
import com.nfta.stopsTransaction.utils.UserValidator;

@RestController
@CrossOrigin(origins="http://localhost:3000")
//@CrossOrigin(origins = "https://nfta-web.herokuapp.com")
public class UserController {

	@Autowired
	AdminService adminService;

	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private LoginResponse response;

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public @ResponseBody String addUser(@RequestBody AdminUser adminUser) {

		String s = "";
		try {
			s = adminService.addUser(adminUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public @ResponseBody String registration(Model model) {
		model.addAttribute("userForm", new User());

		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public @ResponseBody String registration(@RequestBody User userForm, BindingResult bindingResult) {
		userValidator.validate(userForm, bindingResult);
		Gson jsonString = new Gson();
		if (bindingResult.hasErrors()) {
			response.setStatus(false);
			response.setMessage("Error in registration");
			return jsonString.toJson(response);
		}

		userService.save(userForm);

		securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
		response.setStatus(true);
		response.setMessage("Successfully Registered and loggedIn");
		return jsonString.toJson(response);
	}

//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String login(Model model, String error, String logout) {
//		if (error != null)
//			model.addAttribute("error", "Your username and password is invalid.");
//
//		if (logout != null)
//			model.addAttribute("message", "You have been logged out successfully.");
//
//		return "login";
//	}

//	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
//	public String welcome(Model model) {
//		return "welcome";
//	}

	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public String defaultPage() {
		Gson jsonString = new Gson();
		response.setStatus(true);
		response.setMessage("Successfully loggedIn");
		return jsonString.toJson(response);

	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security + Hibernate Example");
		model.addObject("message", "This page is for ROLE_ADMIN only!");
		model.setViewName("admin");

		return model;

	}

//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String login(@RequestParam(value = "error", required = false) String error,
//			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {
//
//		if (error != null) {
//			// model.addObject("error", getErrorMessage(request,
//			// "SPRING_SECURITY_LAST_EXCEPTION"));
//			response.setStatus(false);
//			response.setMessage("Error in processing");
//		}
//
//		if (logout != null) {
//			// model.addObject("msg", "You've been logged out successfully.");
//			response.setStatus(true);
//			response.setMessage("You've been logged out successfully.");
//		}
//		// model.setViewName("login");
//
//		Gson jsonString = new Gson();
//		return jsonString.toJson(response);
//
//	}
//
//	// customize the error message
//	private String getErrorMessage(HttpServletRequest request, String key) {
//
//		Exception exception = (Exception) request.getSession().getAttribute(key);
//
//		String error = "";
//		if (exception instanceof BadCredentialsException) {
//			error = "Invalid username and password!";
//		} else if (exception instanceof LockedException) {
//			error = exception.getMessage();
//		} else {
//			error = "Invalid username and password!";
//		}
//
//		return error;
//	}
//
//	// for 403 access denied page
//	@RequestMapping(value = "/403", method = RequestMethod.GET)
//	public String accesssDenied() {
//
//		ModelAndView model = new ModelAndView();
//
//		// check if user is login
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		if (!(auth instanceof AnonymousAuthenticationToken)) {
//			UserDetails userDetail = (UserDetails) auth.getPrincipal();
//			System.out.println(userDetail);
//
//			model.addObject("username", userDetail.getUsername());
//			response.setMessage(userDetail.getUsername() + " access denied");
//
//		}else {
//			response.setMessage("access denied");
//		}
//		response.setStatus(false);
//		model.setViewName("403");
//
//		Gson jsonString = new Gson();
//		return jsonString.toJson(response);
//
//	}

	@GetMapping("/login")
	public String login(String error, String logout) {
		response.setStatus(false);
		response.setMessage("login");
		if (error != null) {
			// model.addObject("error", getErrorMessage(request,
			// "SPRING_SECURITY_LAST_EXCEPTION"));
			response.setStatus(false);
			response.setMessage("Error in processing");
		}

		if (logout != null) {
			// model.addObject("msg", "You've been logged out successfully.");
			response.setStatus(true);
			response.setMessage("You've been logged out successfully.");
		}
		// model.setViewName("login");

		Gson jsonString = new Gson();
		return jsonString.toJson(response);
		//return "login";
	}

}
