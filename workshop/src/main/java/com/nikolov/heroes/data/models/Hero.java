package com.nikolov.heroes.data.models;

import com.nikolov.heroes.data.models.base.BaseEntity;
import com.nikolov.heroes.data.models.enums.GenderType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "heroes")
public class Hero extends BaseEntity {

	@Column(unique = true)
	private String name;

	@Column
	@Enumerated(EnumType.STRING)
	private GenderType gender;

	@Column
	private int level;

	@Column
	private int stamina;

	@Column
	private int strength;

	@Column
	private int attack;

	@Column
	private int defence;

	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(
			name = "heroes_items",
			joinColumns = {@JoinColumn(name = "hero_id")},
			inverseJoinColumns = {@JoinColumn(name = "item_id")}
	)
	private List<Item> items;

	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
}
