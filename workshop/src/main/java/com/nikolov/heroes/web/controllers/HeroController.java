package com.nikolov.heroes.web.controllers;

import com.nikolov.heroes.web.controllers.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/heroes")
public class HeroController extends BaseController {

	@GetMapping("/create")
	public String create() {
		return "hero/create-hero.html";
	}

	@GetMapping("/details")
	public String details() {
		return "hero/hero-details.html";
	}
}
