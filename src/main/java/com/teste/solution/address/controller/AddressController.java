package com.teste.solution.address.controller;

import com.teste.solution.address.domain.AddressService;
import com.teste.solution.address.domain.dtos.AddressDto;
import com.teste.solution.address.domain.dtos.CreateAddressDto;
import com.teste.solution.address.domain.dtos.UpdateAddressDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/create")
    public ResponseEntity<AddressDto> create(@RequestBody @Valid CreateAddressDto createAddressDto, UriComponentsBuilder uriBuilder) {
        AddressDto addressDto = addressService.create(createAddressDto);

        return ResponseEntity.created(uriBuilder.path("/address/{id}").buildAndExpand(addressDto.id()).toUri())
                .body(addressDto);
    }

    @GetMapping("/all")
    public ResponseEntity<Page<AddressDto>> getAllAddresses(Pageable pageable) {
        return ResponseEntity.ok(addressService.getAllAddresses(pageable));
    }

    @GetMapping("/all/{userId}")
    public ResponseEntity<Page<AddressDto>> getAllAddressesByUserId(@PathVariable UUID userId, Pageable pageable) {
        return ResponseEntity.ok(addressService.getAllAddressesByUserId(userId, pageable));
    }

    @PutMapping("/update")
    public ResponseEntity<AddressDto> update(@RequestBody @Valid UpdateAddressDto updateAddressDto) {
        AddressDto addressDto = addressService.update(updateAddressDto);

        return ResponseEntity.ok(addressDto);
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<Void> delete(@PathVariable UUID addressId) {
        addressService.delete(addressId);
        return ResponseEntity.noContent().build();
    }
}
