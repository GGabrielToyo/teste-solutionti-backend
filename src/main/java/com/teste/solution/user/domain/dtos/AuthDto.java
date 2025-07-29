package com.teste.solution.user.domain.dtos;

import jakarta.validation.constraints.NotBlank;

public record AuthDto(
        @NotBlank(message = "Email is required")
        String email,
        @NotBlank(message = "Password is required")
        String password
) {
}
