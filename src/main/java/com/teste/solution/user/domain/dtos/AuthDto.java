package com.teste.solution.user.domain.dtos;

import jakarta.validation.constraints.NotBlank;

public record AuthDto(
        @NotBlank(message = "CPF is required")
        String cpf,
        @NotBlank(message = "Password is required")
        String password
) {
}
