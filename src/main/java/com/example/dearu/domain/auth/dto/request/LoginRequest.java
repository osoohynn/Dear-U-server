package com.example.dearu.domain.auth.dto.request;

public record LoginRequest(
        String username,
        String password
) {
}
