package com.example.practice.controller;

import com.example.practice.domain.User;
import com.example.practice.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        List<User> list = userService.getAllUser();
        return list;
    }

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        return user;
    }
    @PostMapping("/users")
    public void addUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @DeleteMapping("/users/{userId}")
    public void removeUserById(@PathVariable Long userId) {
        userService.removeUserById(userId);
    }
}
