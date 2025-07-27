package com.teste.solution.address.controller;

import com.teste.solution.address.domain.AddressService;
import com.teste.solution.address.domain.dtos.AddressDto;
import com.teste.solution.address.domain.dtos.CreateAddressDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    public ResponseEntity<AddressDto> create(@RequestBody @Valid CreateAddressDto createAddressDto, UriComponentsBuilder uriBuilder) {
        AddressDto addressDto = addressService.create(createAddressDto);

        return ResponseEntity.created(uriBuilder.path("/address/{id}").buildAndExpand(addressDto.id()).toUri())
                .body(addressDto);
    }
}
