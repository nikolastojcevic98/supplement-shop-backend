package com.supplementshop.controller;

import com.supplementshop.model.User;
import com.supplementshop.repository.UserRepository;
import com.supplementshop.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> loginRequest) {
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");

        User user = userRepository.findAll().stream()
                .filter(u -> u.getEmail().equals(email) && u.getPasswordHash().equals(password))
                .findFirst()
                .orElse(null);

        if (user == null) {
            throw new RuntimeException("Invalid email or password");
        }

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole(), user.getId());

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("user", user);
        return response;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        user.setRole("customer"); // Sigurnosno: uvek customer preko registracije
        return userRepository.save(user);
    }
}
