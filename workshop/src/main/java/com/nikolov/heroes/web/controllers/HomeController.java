package com.nikolov.heroes.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index() {
		return "index.html";
	}

	@GetMapping("/home")
	public String home() {
		return "home/home.html";
	}
}
