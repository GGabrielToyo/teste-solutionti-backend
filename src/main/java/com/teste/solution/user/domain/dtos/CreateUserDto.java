package com.teste.solution.user.domain.dtos;

import jakarta.validation.constraints.NotBlank;

public record CreateUserDto(
        @NotBlank(message = "Name is required")
        String name,
        @NotBlank(message = "CPF is required")
        String cpf
) {
}
