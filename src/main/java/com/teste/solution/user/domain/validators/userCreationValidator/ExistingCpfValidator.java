package com.teste.solution.user.domain.validators.userCreationValidator;

import com.teste.solution.infra.exception.ValidationException;
import com.teste.solution.user.domain.UserRepository;
import com.teste.solution.user.domain.dtos.CreateUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExistingCpfValidator implements UserCreationValidatorInterface{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void validate(CreateUserDto createUserDto) {
        if (userRepository.findByCpf(createUserDto.cpf()).isPresent()) {
            throw new ValidationException("User with CPF " + createUserDto.cpf() + " already exists.");
        }
    }
}
