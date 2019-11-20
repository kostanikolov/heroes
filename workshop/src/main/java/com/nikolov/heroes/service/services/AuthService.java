package com.nikolov.heroes.service.services;

import com.nikolov.heroes.service.models.auth.LoginUserServiceModel;
import com.nikolov.heroes.service.models.auth.RegisterUserServiceModel;

public interface AuthService {

	void register(RegisterUserServiceModel model);

	LoginUserServiceModel login(RegisterUserServiceModel model) throws Exception;
}
