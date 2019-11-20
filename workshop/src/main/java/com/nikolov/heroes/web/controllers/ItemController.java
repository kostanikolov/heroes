package com.nikolov.heroes.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/items")
public class ItemController {

	@GetMapping("/create")
	public String create() {
		return "item/create-item.html";
	}

	@GetMapping("/merchant")
	public String merchant() {
		return "item/merchant.html";
	}
}
