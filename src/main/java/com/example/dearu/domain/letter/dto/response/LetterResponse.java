package com.example.dearu.domain.letter.dto.response;

import com.example.dearu.domain.letter.domian.Letter;
import com.example.dearu.domain.user.dto.request.UserResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LetterResponse{
    private final Long id;
    private final String title;
    private final String content;
    private final UserResponse fromUser;
    private final UserResponse toUser;
    private final boolean isAnonymous;
    private final boolean isRead;

    public static LetterResponse of(Letter letter) {
        return LetterResponse.builder()
                .id(letter.getId())
                .title(letter.getTitle())
                .content(letter.getContent())
                .fromUser(UserResponse.of(letter.getFromUser()))
                .toUser(UserResponse.of(letter.getToUser()))
                .isRead(letter.isRead())
                .build();
    }

    public static LetterResponse ofAnonymous(Letter letter) {
        return LetterResponse.builder()
                .id(letter.getId())
                .title(letter.getTitle())
                .content(letter.getContent())
                .fromUser(null)
                .toUser(UserResponse.of(letter.getToUser()))
                .isRead(letter.isRead())
                .isAnonymous(true)
                .build();
    }
}
