package com.example.dearu.domain.auth.controller;

import com.example.dearu.domain.auth.dto.request.LoginRequest;
import com.example.dearu.domain.auth.dto.request.ReissueRequest;
import com.example.dearu.domain.auth.dto.request.SignUpRequest;
import com.example.dearu.domain.auth.service.AuthService;
import com.example.dearu.domain.user.dto.request.UserResponse;
import com.example.dearu.global.security.jwt.dto.Jwt;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public void signup(@RequestBody SignUpRequest request) {
        authService.signup(request);
    }

    @PostMapping("/login")
    public Jwt login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @PostMapping("/reissue")
    public Jwt reissue(@RequestBody ReissueRequest request) {
        return authService.reissue(request);
    }

    @GetMapping("/me")
    public UserResponse me() {
        return authService.me();
    }
}
