package com.teste.solution.address.domain;

import com.teste.solution.address.domain.dtos.AddressDto;
import com.teste.solution.address.domain.dtos.CreateAddressDto;
import com.teste.solution.infra.exception.ValidationException;
import com.teste.solution.user.domain.User;
import com.teste.solution.user.domain.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserService userService;

    public AddressDto create(CreateAddressDto createAddressDto) {
        User user = userService.createOrSearch(createAddressDto.user());

        Address address = new Address(createAddressDto, user);

        addressRepository.save(address);

        return new AddressDto(address);
    }

    public AddressDto getAddressById(UUID id){
        return addressRepository.findById(id)
                .map(AddressDto::new)
                .orElseThrow(() -> new ValidationException("Address not found"));
    }

    public Page<AddressDto> getAllAddresses(Pageable pageable) {
        return addressRepository.findAll(pageable)
                .map(AddressDto::new);
    }
}
