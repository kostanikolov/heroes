package com.nikolov.heroes.service.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HeroCreateServiceModel {
	private String name;
	private String gender;
}
