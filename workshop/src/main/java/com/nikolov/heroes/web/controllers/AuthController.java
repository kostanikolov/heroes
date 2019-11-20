package com.nikolov.heroes.web.controllers;

import com.nikolov.heroes.service.models.auth.RegisterUserServiceModel;
import com.nikolov.heroes.service.services.AuthService;
import com.nikolov.heroes.web.models.RegisterUserModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class AuthController {

	private final AuthService authService;
	private final ModelMapper mapper;

	public AuthController(AuthService authService, ModelMapper mapper) {
		this.authService = authService;
		this.mapper = mapper;
	}

	@GetMapping("/login")
	public String login() {
		return "auth/login.html";
	}

	@PostMapping("/login")
	public void loginConfirm() {

	}

	@GetMapping("/register")
	public String register() {
		return "auth/register.html";
	}

	@PostMapping("/register")
	public String registerConfirm(@ModelAttribute RegisterUserModel model) {
		RegisterUserServiceModel serviceModel = mapper.map(model, RegisterUserServiceModel.class);
		this.authService.register(serviceModel);
		return "redirect:/";
	}
}
