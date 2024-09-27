package com.example.dearu.domain.letter.dto.request;

public record LetterCreateRequest(
        String name,
        String content,
        boolean isAnonymous
) {
}
