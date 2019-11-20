package com.nikolov.heroes.data.models;

import com.nikolov.heroes.data.models.base.BaseEntity;
import com.nikolov.heroes.data.models.enums.SlotType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "items")
public class Item extends BaseEntity {

	@Column
	private String name;

	@Column
	@Enumerated(EnumType.STRING)
	private SlotType slot;

	@Column
	private int stamina;

	@Column
	private int strength;

	@Column
	private int attack;

	@Column
	private int defence;

	@ManyToMany(mappedBy = "items")
	private List<Hero> heroes;
}
