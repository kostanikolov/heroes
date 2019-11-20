package com.nikolov.heroes.service.factories;

import com.nikolov.heroes.data.models.Hero;

public interface HeroFactory {
	Hero create(String name, String gender);
}
