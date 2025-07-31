package com.teste.solution.user.controller;

import com.teste.solution.user.domain.UserService;
import com.teste.solution.user.domain.dtos.UpdateUserDto;
import com.teste.solution.user.domain.dtos.UserDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("/update")
    public ResponseEntity<UserDto> update(@RequestBody @Valid UpdateUserDto updateUserDto) {
        UserDto userDto = userService.update(updateUserDto);

        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/me")
    public ResponseEntity<UserDto> getUserByJWT(@AuthenticationPrincipal UserDetails userDetails){
        return ResponseEntity.ok(userService.getUserByEmail(userDetails.getUsername()));
    }

}
