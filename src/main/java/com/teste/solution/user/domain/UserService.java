package com.teste.solution.user.domain;

import com.teste.solution.user.domain.dtos.CreateUserDto;
import com.teste.solution.user.domain.dtos.UpdateUserDto;
import com.teste.solution.user.domain.dtos.UserDto;
import com.teste.solution.user.domain.validators.userCreationValidator.UserCreationValidatorInterface;
import com.teste.solution.util.enums.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private List<UserCreationValidatorInterface> validators;

    @Transactional
    public User create(CreateUserDto createUserDto, RoleEnum role) {
        validators.forEach(v -> v.validate(createUserDto));

        User user = new User(createUserDto, role);

        userRepository.save(user);

        return user;
    }

    @Transactional
    public UserDto update(UpdateUserDto updateUserDto) {
        User user = getUserEntityById(updateUserDto.id());

        user.update(updateUserDto);

        return new UserDto(user);
    }

    public User getUserEntityById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);

        if (user != null) {
            return new UserDto(user);
        } else {
            return null;
        }
    }

    public User getUserByCpf(String cpf){
        if(userRepository.findByCpf(cpf).isPresent()) {
            return userRepository.findByCpf(cpf).get();
        } else {
            return null;
        }
    }
}
