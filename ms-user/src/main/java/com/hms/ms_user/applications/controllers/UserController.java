package com.hms.ms_user.applications.controllers;

import com.hms.ms_user.applications.dtos.UserDto;
import com.hms.ms_user.applications.services.UserService;
import com.hms.ms_user.domain.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userDto));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUser(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }

}
