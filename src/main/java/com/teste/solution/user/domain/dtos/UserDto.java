package com.teste.solution.user.domain.dtos;

import com.teste.solution.user.domain.User;

import java.util.UUID;

public record UserDto(
        UUID id,
        String name,
        String cpf,
        String createdAt
) {
    public UserDto(User user) {
        this(
                user.getId(),
                user.getName(),
                user.getCpf(),
                user.getCreatedAt().toString()
        );
    }
}
