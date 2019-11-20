package com.nikolov.heroes.service.services;

import com.nikolov.heroes.service.models.auth.RegisterUserServiceModel;

public interface AuthValidationService {

	boolean isValid(RegisterUserServiceModel model);
}
