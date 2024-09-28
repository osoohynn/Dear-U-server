package com.example.dearu.domain.letter.dto.response;

import com.example.dearu.domain.letter.domian.Letter;
import com.example.dearu.domain.user.domain.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LetterResponse{
    private final Long id;
    private final String content;
    private final User fromUser;
    private final User toUser;
    private final boolean isRead;

    public static LetterResponse of(Letter letter) {
        return LetterResponse.builder()
                .id(letter.getId())
                .content(letter.getContent())
                .fromUser(letter.getFromUser())
                .toUser(letter.getToUser())
                .isRead(letter.isRead())
                .build();
    }

    public static LetterResponse ofAnonymous(Letter letter) {
        return LetterResponse.builder()
                .id(letter.getId())
                .content(letter.getContent())
                .fromUser(null)
                .toUser(letter.getToUser())
                .isRead(letter.isRead())
                .build();
    }
}
