package com.teste.solution.address.domain.dtos;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UpdateAddressDto(
        @NotNull(message = "ID is required")
        UUID id,
        String zipCode,
        String street,
        String complement,
        String unit,
        String district,
        String city,
        String stateAbbr,
        String region,
        String ibgeCode,
        String giaCode,
        String areaCode,
        String siafiCode
) {
}
