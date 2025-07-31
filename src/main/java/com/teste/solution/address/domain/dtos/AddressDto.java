package com.teste.solution.address.domain.dtos;

import com.teste.solution.address.domain.Address;
import com.teste.solution.user.domain.dtos.UserDto;

import java.util.UUID;

public record AddressDto(
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
        String siafiCode,
        UserDto user
) {
    public AddressDto(Address address) {
        this(
                address.getId(),
                address.getZipCode(),
                address.getStreet(),
                address.getComplement(),
                address.getUnit(),
                address.getDistrict(),
                address.getCity(),
                address.getStateAbbr(),
                address.getRegion(),
                address.getIbgeCode(),
                address.getGiaCode(),
                address.getAreaCode(),
                address.getSiafiCode(),
                new UserDto(address.getUser())
        );
    }
}
