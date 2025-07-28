package com.teste.solution.user.domain.validators.userCreationValidator;

import com.teste.solution.infra.exception.ValidationException;
import com.teste.solution.user.domain.dtos.CreateUserDto;
import org.springframework.stereotype.Component;

@Component
public class PasswordMatchValidator implements UserCreationValidatorInterface {

    @Override
    public void validate(CreateUserDto createUserDto) {
        if (!createUserDto.password().equals(createUserDto.passwordConfirmation())) {
            throw new ValidationException("Passwords do not match");
        }
    }
}
