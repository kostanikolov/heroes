package com.nikolov.heroes.service.models;

import com.nikolov.heroes.data.models.enums.GenderType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HeroDetailsServiceModel {

	private String name;
	private GenderType gender;
	private int level;
	private int stamina;
	private int strength;
	private int attack;
	private int defence;

	private HeroItemServiceModel weapon;
	private HeroItemServiceModel pads;
	private HeroItemServiceModel gauntlets;
	private HeroItemServiceModel pauldrons;
	private HeroItemServiceModel helmet;
}
