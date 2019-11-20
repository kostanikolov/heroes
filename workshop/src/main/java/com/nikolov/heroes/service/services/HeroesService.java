package com.nikolov.heroes.service.services;

import com.nikolov.heroes.data.models.Hero;
import com.nikolov.heroes.service.models.HeroCreateServiceModel;
import com.nikolov.heroes.service.models.HeroDetailsServiceModel;

public interface HeroesService {
	HeroDetailsServiceModel getByName(String name);

	Hero create(HeroCreateServiceModel serviceModel);
}
