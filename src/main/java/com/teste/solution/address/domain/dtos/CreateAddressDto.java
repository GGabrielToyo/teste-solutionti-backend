package com.teste.solution.address.domain.dtos;

import com.teste.solution.user.domain.User;
import com.teste.solution.user.domain.dtos.CreateUserDto;

public record CreateAddressDto(
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
        String siafiCode,
        CreateUserDto user
) {
}
