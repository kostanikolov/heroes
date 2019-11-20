package com.nikolov.heroes.service.services.implementations;

import com.nikolov.heroes.data.models.Hero;
import com.nikolov.heroes.data.models.User;
import com.nikolov.heroes.data.repositories.UserRepository;
import com.nikolov.heroes.service.models.HeroCreateServiceModel;
import com.nikolov.heroes.service.services.HeroesService;
import com.nikolov.heroes.service.services.UsersService;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
	private final HeroesService heroesService;
	private final UserRepository userRepository;

	public UsersServiceImpl(HeroesService heroesService, UserRepository userRepository) {
		this.heroesService = heroesService;
		this.userRepository = userRepository;
	}

	@Override
	public void createHeroForUser(String username, HeroCreateServiceModel model) {
		User user = this.userRepository.findByUsername(username);
		Hero hero = this.heroesService.create(model);
		hero.setUser(user);
		this.userRepository.save(user);
	}
}
