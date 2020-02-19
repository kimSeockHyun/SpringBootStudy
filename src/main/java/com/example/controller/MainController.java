package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping(value ="/")
	public String index() {
		return "index";
	}
	
	@GetMapping(value = "/joinPage")
	public String joinPage() {
		return "join";
	}
	
	@GetMapping(value = "/loginPage")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping(value = "/logoutPage")
	public String logoutPage() {
		session.invalidate();
		return "index";
	}
	
}
