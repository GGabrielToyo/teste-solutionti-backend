package com.teste.solution.user.controller;

import com.teste.solution.user.domain.UserService;
import com.teste.solution.user.domain.dtos.AuthDto;
import com.teste.solution.user.domain.dtos.CreateUserDto;
import com.teste.solution.user.domain.dtos.UserDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserDto> create(@RequestBody @Valid CreateUserDto createUserDto, UriComponentsBuilder uriBuilder) {
        UserDto userDto = new UserDto(userService.create(createUserDto));

        return ResponseEntity.created(uriBuilder.path("/user/{id}").buildAndExpand(userDto.id()).toUri())
                .body(userDto);
    }

    @PostMapping("signin")
    public ResponseEntity<String> signIn(@RequestBody @Valid AuthDto authDto) {


        return ResponseEntity.ok(null);
    }
}
