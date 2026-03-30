package com.proj.subscriptionTracker.service;

import com.proj.subscriptionTracker.model.User;
import com.proj.subscriptionTracker.repository.UserRepository;
import com.proj.subscriptionTracker.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private JwtUtil jwtUtil;

    public String register(User user) {
        repo.save(user);
        return jwtUtil.generateToken(user.getId());
    }

    public String login(String email, String password) {
        Optional<User> user = repo.findByEmail(email);

        if (user.isEmpty() || !user.get().getPassword().equals(password)) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtUtil.generateToken(user.get().getId());
    }
}