package com.src.starters.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String showHome(){
		return "index";
	}
	
}