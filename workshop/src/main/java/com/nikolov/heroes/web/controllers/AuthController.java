package com.nikolov.heroes.web.controllers;

import com.nikolov.heroes.data.repositories.UserRepository;
import com.nikolov.heroes.service.models.auth.LoginUserServiceModel;
import com.nikolov.heroes.service.models.auth.RegisterUserServiceModel;
import com.nikolov.heroes.service.services.AuthService;
import com.nikolov.heroes.web.models.RegisterUserModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class AuthController {

	private final AuthService authService;
	private final UserRepository userRepository;
	private final ModelMapper mapper;

	public AuthController(AuthService authService, UserRepository userRepository, ModelMapper mapper) {
		this.authService = authService;
		this.userRepository = userRepository;
		this.mapper = mapper;
	}

	@GetMapping("/login")
	public String login() {
		return "auth/login.html";
	}

	@PostMapping("/login")
	public String loginConfirm(@ModelAttribute RegisterUserModel model, HttpSession session) {
		RegisterUserServiceModel registerServiceModel = this.mapper.map(model, RegisterUserServiceModel.class);
		String email = this.userRepository.findByUsername(model.getUsername()).getEmail();
		int heroLevel = this.userRepository.findByUsername(model.getUsername()).getHero().getLevel();

		try {
			LoginUserServiceModel loginServiceModel = this.authService.login(registerServiceModel);
			session.setAttribute("user", loginServiceModel);
			session.setAttribute("email", email);
			session.setAttribute("heroLevel", heroLevel);
			return "redirect:/";
		} catch (Exception e) {
			return "redirect:/users/login";
		}
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
