package com.example.dearu.domain.letter.dto.response;

import com.example.dearu.domain.letter.domian.Letter;
import com.example.dearu.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LetterResponse{
    private final Long id;
    private final String content;
    private final User fromUser;
    private final User toUser;

    public static LetterResponse of(Letter letter) {
        return LetterResponse.builder()
                .id(letter.getId())
                .content(letter.getContent())
                .fromUser(letter.getFromUser())
                .toUser(letter.getToUser())
                .build();
    }
}
