package com.nikolov.heroes.web.controllers;

import com.nikolov.heroes.service.models.HeroCreateServiceModel;
import com.nikolov.heroes.service.models.HeroDetailsServiceModel;
import com.nikolov.heroes.service.services.HeroesService;
import com.nikolov.heroes.service.services.UsersService;
import com.nikolov.heroes.web.controllers.base.BaseController;
import com.nikolov.heroes.web.models.HeroCreateModel;
import com.nikolov.heroes.web.models.HeroDetailsViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/heroes")
public class HeroController extends BaseController {

	private final UsersService usersService;
	private final ModelMapper mapper;
	private final HeroesService heroesService;

	public HeroController(UsersService usersService, ModelMapper mapper, HeroesService heroesService) {
		this.usersService = usersService;
		this.mapper = mapper;
		this.heroesService = heroesService;
	}

	@GetMapping("/create")
	public String create() {
		return "hero/create-hero.html";
	}

	@PostMapping("/create")
	public String createConfirm(@ModelAttribute HeroCreateModel heroModel, HttpSession session) {
		if (!isAuthenticated(session)) {
			return "/";
		}

		String username = getUsername(session);
		HeroCreateServiceModel serviceModel = this.mapper.map(heroModel, HeroCreateServiceModel.class);
		this.usersService.createHeroForUser(username, serviceModel);

		return "redirect:/heroes/details/" + heroModel.getName();
	}

	@GetMapping("/details/{name}")
	public ModelAndView details(@PathVariable String name, ModelAndView modelAndView) {
		HeroDetailsServiceModel serviceModel = heroesService.getByName(name);
		HeroDetailsViewModel viewModel = this.mapper.map(serviceModel, HeroDetailsViewModel.class);

		modelAndView.addObject("hero", viewModel);
		modelAndView.setViewName("hero/hero-details.html");
		return modelAndView;
	}
}
