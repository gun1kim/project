package com.example.practice.service;

import com.example.practice.domain.User;
import com.example.practice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no such data"));
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }





}
