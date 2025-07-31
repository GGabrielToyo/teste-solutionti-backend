package com.teste.solution.user.domain.dtos;

import com.teste.solution.user.domain.User;
import com.teste.solution.util.enums.RoleEnum;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserDto(
        UUID id,
        String name,
        String email,
        String cpf,
        RoleEnum role,
        LocalDateTime createdAt
) {
    public UserDto(User user) {
        this(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCpf(),
                user.getRole(),
                user.getCreatedAt()
        );
    }
}
