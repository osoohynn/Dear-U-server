package com.example.dearu.domain.letter.error;

import com.example.dearu.global.exception.CustomError;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum LetterError implements CustomError {
    LETTER_NOT_FOUND(HttpStatus.BAD_REQUEST, "Letter not found")
    ;

    private final HttpStatus status;
    private final String message;

    @Override
    public String getCode() {
        return name();
    }
}
