package com.craftincode.startspring.controllers;

import com.craftincode.startspring.dto.CreateUserDto;
import com.craftincode.startspring.dto.UpdateUserDto;
import com.craftincode.startspring.dto.UserDto;
import com.craftincode.startspring.exceptions.AlreadyExists;
import com.craftincode.startspring.exceptions.InvalidData;
import com.craftincode.startspring.exceptions.NotFound;
import com.craftincode.startspring.model.User;
import com.craftincode.startspring.model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDto> getAllUsers(@RequestParam(required = false) Integer birthYear,
                                     @RequestParam(required = false) String sortBy,
                                     @RequestParam(required = false) String sortOrder) {
        return userService.getAllUsers(birthYear, sortBy, sortBy);
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable int id) throws NotFound {
        return userService.getUserById(id);
    }

    @PostMapping
    public UserDto addUser(@RequestBody CreateUserDto user) throws InvalidData, AlreadyExists {
        return userService.addUser(user);
    }

    @PutMapping("/{id}")
    public UserDto updateUserById(@PathVariable int id, @RequestBody UpdateUserDto updateUserDto) throws InvalidData, AlreadyExists, NotFound {
        return userService.updateUserById(id, updateUserDto);
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable int id) throws NotFound {
        userService.deleteUserById(id);
        return "User has been deleted";
    }
}
