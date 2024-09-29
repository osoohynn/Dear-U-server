package com.example.dearu.domain.letter.controller;


import com.example.dearu.domain.letter.dto.request.LetterCreateRequest;
import com.example.dearu.domain.letter.dto.request.LetterUpdateRequest;
import com.example.dearu.domain.letter.dto.response.LetterResponse;
import com.example.dearu.domain.letter.service.LetterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/letters")
public class LetterController {
    private final LetterService letterService;

    @PostMapping
    public void createLetter(@RequestBody LetterCreateRequest request) {
        letterService.createLetter(request);
    }

    @GetMapping
    public List<LetterResponse> getLetters() {
        return letterService.getLetters();
    }

    @GetMapping("/{letterId}")
    public LetterResponse getLetter(@PathVariable Long letterId) {
        return letterService.getLetter(letterId);
    }

    @PatchMapping("/{letterId}")
    public void updateLetter(@PathVariable Long letterId, @RequestBody LetterUpdateRequest request) {
        letterService.updateLetter(letterId, request);
    }
}
