package com.teste.solution.user.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UpdateUserDto(
        @NotNull(message = "ID is required")
        UUID id,
        String name,
        String email,
        String cpf,
        String password,
        String passwordConfirmation
) {
}
