package com.nikolov.heroes.data.models;

import com.nikolov.heroes.data.models.base.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User extends BaseEntity {

	@Column
	private String username;

	@Column
	private String password;

	@Column
	private String email;

	@OneToOne(mappedBy = "user")
	private Hero hero;
}
