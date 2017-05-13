package com.src.starters.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/login")
	public String loginForm(){
		return "login";
	}
	
	@RequestMapping("/home")
	public String showHome(){
		return "partials/home";
	}
	
	@RequestMapping("/account")
	public String mainPage(){
		return "index";
	}
	
	@RequestMapping("/signUp")
	public String form(){
		return "partials/signUpForm";
	}
	
}
