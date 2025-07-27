package com.teste.solution.address.domain.dtos;

import com.teste.solution.address.domain.Address;
import com.teste.solution.user.domain.dtos.UserDto;

import java.util.UUID;

public record AddressDto(
        UUID id,
        String street,
        String district,
        String city,
        String region,
        UserDto user
) {
    public AddressDto(Address address) {
        this(
                address.getId(),
                address.getStreet(),
                address.getDistrict(),
                address.getCity(),
                address.getRegion(),
                new UserDto(address.getUser())
        );
    }
}
