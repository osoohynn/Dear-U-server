package com.example.dearu.domain.letter.dto.request;

public record LetterCreateRequest(
        String username,
        String content,
        boolean isAnonymous
) {
}
