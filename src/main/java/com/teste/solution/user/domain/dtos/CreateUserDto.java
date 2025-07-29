package com.teste.solution.user.domain.dtos;

import jakarta.validation.constraints.NotBlank;

public record CreateUserDto(
        @NotBlank(message = "Name is required")
        String name,
        @NotBlank(message = "Email is required")
        String email,
        @NotBlank(message = "CPF is required")
        String cpf,
        @NotBlank(message = "Password is required")
        String password,
        @NotBlank(message = "Password confirmation is required")
        String passwordConfirmation
) {
}
