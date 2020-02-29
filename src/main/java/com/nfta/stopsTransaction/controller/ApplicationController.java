package com.nfta.stopsTransaction.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ApplicationController {

	private static String WELCOME = "Welcome to my NFTA Application";
	

	@RequestMapping("home")
	public String welcome() {// Welcome page, non-rest
		return WELCOME;
	}

	@RequestMapping("home/{name}")
	public String message(@PathVariable String name) {
		String msg = "Hello " + name;
		return msg;
	}

}
