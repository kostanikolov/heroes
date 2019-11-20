package com.nikolov.heroes.data.repositories;

import com.nikolov.heroes.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	boolean existsByUsername(String username);

	Optional<User> findByUsernameAndPassword(String username, String password);

	User findByUsername(String username);
}
