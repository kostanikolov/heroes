package com.nikolov.heroes.data.repositories;

import com.nikolov.heroes.data.models.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeroRepository extends JpaRepository<Hero, String> {
	Optional<Hero> getByNameIgnoreCase(String name);
}
