package com.nikolov.heroes.web.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HeroCreateModel {
	private String name;
	private String gender;
}
