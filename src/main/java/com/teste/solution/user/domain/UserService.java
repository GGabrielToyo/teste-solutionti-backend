package com.teste.solution.user.domain;

import com.teste.solution.infra.exception.ValidationException;
import com.teste.solution.user.domain.dtos.CreateUserDto;
import com.teste.solution.user.domain.dtos.UserDto;
import com.teste.solution.user.domain.validators.userCreationValidator.UserCreationValidatorInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private List<UserCreationValidatorInterface> validators;

    @Transactional
    public User createOrSearch(CreateUserDto createUserDto) {
        User user = getUserByCpf(createUserDto.cpf());

        if(user != null){
            return user;
        }

        user = new User(createUserDto);
        userRepository.save(user);

        return user;
    }

    public User getUserByCpf(String cpf){
        if(userRepository.findByCpf(cpf).isPresent()) {
            return userRepository.findByCpf(cpf).get();
        } else {
            return null;
        }
    }
}
