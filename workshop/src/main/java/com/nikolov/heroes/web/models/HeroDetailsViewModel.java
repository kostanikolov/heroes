package com.nikolov.heroes.web.models;

import com.nikolov.heroes.data.models.enums.GenderType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HeroDetailsViewModel {
	private String name;
	private GenderType gender;
	private int level;
	private int stamina;
	private int strength;
	private int attack;
	private int defence;

	private HeroItemViewModel weapon;
	private HeroItemViewModel pads;
	private HeroItemViewModel gauntlets;
	private HeroItemViewModel pauldrons;
	private HeroItemViewModel helmet;
}
