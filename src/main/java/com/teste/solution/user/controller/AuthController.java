package com.teste.solution.user.controller;

import com.teste.solution.infra.security.TokenService;
import com.teste.solution.user.domain.User;
import com.teste.solution.user.domain.UserService;
import com.teste.solution.user.domain.dtos.AuthDto;
import com.teste.solution.user.domain.dtos.CreateUserDto;
import com.teste.solution.user.domain.dtos.UserDto;
import com.teste.solution.util.enums.RoleEnum;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/signup")
    public ResponseEntity<UserDto> create(@RequestBody @Valid CreateUserDto createUserDto, UriComponentsBuilder uriBuilder) {
        UserDto userDto = new UserDto(userService.create(createUserDto, RoleEnum.USER));

        return ResponseEntity.created(uriBuilder.path("/user/{id}").buildAndExpand(userDto.id()).toUri())
                .body(userDto);
    }

    @PostMapping("/create-admin")
    public ResponseEntity<UserDto> createAdmin(@RequestBody @Valid CreateUserDto createUserDto, UriComponentsBuilder uriBuilder) {
        UserDto userDto = new UserDto(userService.create(createUserDto, RoleEnum.ADMIN));

        return ResponseEntity.created(uriBuilder.path("/user/{id}").buildAndExpand(userDto.id()).toUri())
                .body(userDto);
    }

    @PostMapping("signin")
    public ResponseEntity<String> signIn(@RequestBody @Valid AuthDto authDto) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(authDto.email(), authDto.password());
        var authentication = manager.authenticate(authenticationToken);
        var user = (User) authentication.getPrincipal();

        return ResponseEntity.ok(tokenService.getToken(user));
    }
}
