package com.nikolov.heroes.service.factories.base;

import com.nikolov.heroes.config.annotations.Factory;
import com.nikolov.heroes.data.models.Hero;
import com.nikolov.heroes.data.models.enums.GenderType;
import com.nikolov.heroes.service.factories.HeroFactory;

@Factory
public class HeroFactoryImpl implements HeroFactory {

	@Override
	public Hero create(String name, String gender) {
		Hero hero = new Hero();
		hero.setName(name);
		hero.setGender(GenderType.valueOf(gender.toUpperCase()));
		hero.setAttack(1);
		hero.setDefence(1);
		hero.setLevel(1);
		hero.setStamina(1);
		hero.setStrength(1);
		return hero;
	}
}
