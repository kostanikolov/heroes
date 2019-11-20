package com.nikolov.heroes.service.services;

import com.nikolov.heroes.service.models.HeroCreateServiceModel;

public interface UsersService {
	void createHeroForUser(String username, HeroCreateServiceModel model);
}
