package com.example.dearu.domain.user.dto.request;

import com.example.dearu.domain.user.domain.User;
import com.example.dearu.domain.user.domain.UserRole;

public record UserResponse(
        Long id,
        String username,
        UserRole role) {

    public static UserResponse of(User user) {
        return new UserResponse(user.getId(), user.getUsername(), user.getRole());
    }
}