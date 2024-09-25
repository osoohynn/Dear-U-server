package com.example.dearu.global.security.session;

import com.example.dearu.domain.user.domain.User;
import com.example.dearu.domain.user.error.UserError;
import com.example.dearu.domain.user.repository.UserRepository;
import com.example.dearu.global.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserSession {
    private final UserRepository userRepository;

    public User getUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        return userRepository.findByUsername(username)
                .orElseThrow(() -> new CustomException(UserError.USER_NOT_FOUND));
    }
}