package com.example.dearu.global.security.jwt.dto;

public record Jwt(
        String accessToken,
        String refreshToken
) {
}
