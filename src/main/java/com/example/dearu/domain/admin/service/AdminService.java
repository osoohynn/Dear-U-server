package com.example.dearu.domain.admin.service;


import com.example.dearu.domain.letter.domian.Letter;
import com.example.dearu.domain.letter.repository.LetterRepository;
import com.example.dearu.domain.user.domain.User;
import com.example.dearu.domain.user.error.UserError;
import com.example.dearu.domain.user.repository.UserRepository;
import com.example.dearu.global.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final UserRepository userRepository;
    private final LetterRepository letterRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new CustomException(UserError.USER_NOT_FOUND));
    }

    public List<Letter> getLetter() {
        return letterRepository.findAll();
    }
}
