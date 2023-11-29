package com.example.practice.controller;

import com.example.practice.domain.Gathering;
import com.example.practice.domain.User;
import com.example.practice.domain.UserGathering;
import com.example.practice.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
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

    @GetMapping("/users/{userId}/gatherings")
    public List<Gathering> getUserGatherings(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        List<UserGathering> userGatherings = user.getUserGatherings();

        List<Gathering> gatherings = userGatherings.stream()
                .map(UserGathering::getGathering)
                .collect(Collectors.toList());

        log.info("gatherings = {}", gatherings);
        return gatherings;
    }
}
