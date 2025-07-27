package com.teste.solution.user.domain.validators.userCreationValidator;

import com.teste.solution.user.domain.dtos.CreateUserDto;

public interface UserCreationValidatorInterface {
    void validate(CreateUserDto createUserDto);
}
