package com.example.dearu.domain.letter.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LetterController {

    @GetMapping
    public String index() {
        return "성공";
    }
}
