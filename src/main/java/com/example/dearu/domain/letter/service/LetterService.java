package com.example.dearu.domain.letter.service;


import com.example.dearu.domain.letter.domian.Letter;
import com.example.dearu.domain.letter.dto.request.LetterCreateRequest;
import com.example.dearu.domain.letter.dto.response.LetterResponse;
import com.example.dearu.domain.letter.error.LetterError;
import com.example.dearu.domain.letter.repository.LetterRepository;
import com.example.dearu.domain.user.domain.User;
import com.example.dearu.domain.user.error.UserError;
import com.example.dearu.domain.user.repository.UserRepository;
import com.example.dearu.global.exception.CustomException;
import com.example.dearu.global.security.session.UserSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LetterService {
    private final LetterRepository letterRepository;
    private final UserRepository userRepository;
    private final UserSession userSession;

    public void createLetter(LetterCreateRequest request) {
        User toUser = userRepository.findByUsername(request.username()).orElseThrow(() -> new CustomException(UserError.USER_NOT_FOUND));
        User fromUser = userSession.getUser();

        Letter letter = Letter.builder()
                .fromUser(fromUser)
                .toUser(toUser)
                .content(request.content())
                .build();

        letterRepository.save(letter);
    }

    public LetterResponse getLetter(Long id) {
        Letter letter = letterRepository.findById(id).orElseThrow(() -> new CustomException(LetterError.LETTER_NOT_FOUND));
        return LetterResponse.of(letter);
    }

    public List<LetterResponse> getLetters() {
        User fromUser = userSession.getUser();
        List<Letter> letters = letterRepository.findByFromUser(fromUser);
        return letters.stream().map(LetterResponse::of).toList();
    }
}
