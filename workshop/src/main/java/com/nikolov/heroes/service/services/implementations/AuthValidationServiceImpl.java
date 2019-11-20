package com.nikolov.heroes.service.services.implementations;

import com.nikolov.heroes.data.repositories.UserRepository;
import com.nikolov.heroes.service.models.auth.RegisterUserServiceModel;
import com.nikolov.heroes.service.services.AuthValidationService;
import org.springframework.stereotype.Service;

@Service
public class AuthValidationServiceImpl implements AuthValidationService {

	private final UserRepository userRepository;

	public AuthValidationServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public boolean isValid(RegisterUserServiceModel user) {
		return this.isEmailValid(user.getEmail()) &&
				this.arePasswordsValid(user.getPassword(), user.getConfirmPassword()) &&
				this.isUsernameFree(user.getUsername());
	}

	private boolean arePasswordsValid(String password, String confirmPassword) {
		return password.equals(confirmPassword);
	}

	private boolean isUsernameFree(String username) {
		return !userRepository.existsByUsername(username);
	}

	private boolean isEmailValid(String email) {
		return true;
	}
}
