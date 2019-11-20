package com.nikolov.heroes.service.services.implementations;

import com.nikolov.heroes.data.models.User;
import com.nikolov.heroes.data.repositories.UserRepository;
import com.nikolov.heroes.service.models.auth.LoginUserServiceModel;
import com.nikolov.heroes.service.models.auth.RegisterUserServiceModel;
import com.nikolov.heroes.service.services.AuthService;
import com.nikolov.heroes.service.services.AuthValidationService;
import com.nikolov.heroes.service.services.HashingService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

	private final AuthValidationService authValidationService;
	private final UserRepository userRepository;
	private final ModelMapper mapper;
	private final HashingService hashingService;

	public AuthServiceImpl(AuthValidationService authValidationService,
						   UserRepository userRepository,
						   ModelMapper mapper,
						   HashingService hashingService) {

		this.authValidationService = authValidationService;
		this.userRepository = userRepository;
		this.mapper = mapper;
		this.hashingService = hashingService;
	}

	@Override
	public void register(RegisterUserServiceModel model) {
		if (!authValidationService.isValid(model)) {
			// throw exception
			return;
		}

		User user = mapper.map(model, User.class);
		user.setPassword(hashingService.hash(model.getPassword()));
		this.userRepository.save(user);
	}

	@Override
	public LoginUserServiceModel login(RegisterUserServiceModel model) throws Exception {
		String passwordHash = this.hashingService.hash(model.getPassword());
		return this.userRepository.findByUsernameAndPassword(model.getUsername(), passwordHash)
				.map(user -> {
					String heroName = user.getHero() == null
							? null
							: user.getHero().getName();

					return new LoginUserServiceModel(model.getUsername(), heroName);
				})
				.orElseThrow(() -> new Exception("Invalid user"));
	}
}
