package com.example.dearu.domain.letter.service;


import com.example.dearu.domain.letter.domian.Letter;
import com.example.dearu.domain.letter.dto.request.LetterCreateRequest;
import com.example.dearu.domain.letter.dto.request.LetterUpdateRequest;
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
        User toUser = selectUser(request.name());
        if (toUser == null) {
            throw new CustomException(UserError.USER_NOT_FOUND);
        }
        User fromUser = userSession.getUser();

        Letter letter = Letter.builder()
                .fromUser(fromUser)
                .toUser(toUser)
                .title(request.title())
                .content(request.content())
                .isAnonymous(request.isAnonymous())
                .build();

        letterRepository.save(letter);
    }

    public LetterResponse getLetter(Long id) {
        Letter letter = letterRepository.findById(id).orElseThrow(() -> new CustomException(LetterError.LETTER_NOT_FOUND));

        if (letter.getToUser().equals(userSession.getUser())) {
            letter.setRead(true);
            letterRepository.save(letter);
        }

        return letter.isAnonymous() ? LetterResponse.ofAnonymous(letter) : LetterResponse.of(letter);
    }

    public List<LetterResponse> getMyLetters() {
        User fromUser = userSession.getUser();
        List<Letter> letters = letterRepository.findByFromUser(fromUser);
        return letters.stream().map((letter) -> letter.isAnonymous() ? LetterResponse.ofAnonymous(letter) : LetterResponse.of(letter)).toList();
    }

    public List<LetterResponse> getReceivedLetters() {
        User toUser = userSession.getUser();
        List<Letter> letters = letterRepository.findByToUser(toUser);
        return letters.stream().map((letter) -> letter.isAnonymous() ? LetterResponse.ofAnonymous(letter) : LetterResponse.of(letter)).toList();
    }

    public void updateLetter(Long id, LetterUpdateRequest request) {
        Letter letter = letterRepository.findById(id).orElseThrow(() -> new CustomException(LetterError.LETTER_NOT_FOUND));
        letter.setTitle(request.title());
        letter.setContent(request.content());

        letterRepository.save(letter);
    }

    public void deleteLetter(Long id) {
        letterRepository.deleteById(id);
    }

    public User selectUser(String name) {
        List<User> users = userRepository.findAllByName(name);
        if (users.size() > 1) {
            // 사용자 선택 로직 (여기서는 단순히 첫 번째 사용자를 선택하는 예시)
            // 실제로는 클라이언트에서 사용자 선택 UI를 제공해야 함
            return users.get(0);
        } else if (users.size() == 1) {
            return users.get(0);
        } else {
            throw new CustomException(UserError.USER_NOT_FOUND);
        }
    }
}
