package com.example.dearu.domain.admin.controller;


import com.example.dearu.domain.admin.service.AdminService;
import com.example.dearu.domain.letter.domian.Letter;
import com.example.dearu.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/users")
    private List<User> getUsers() {
        return adminService.getUsers();
    }

    @GetMapping("/users/{userId}")
    private User getUser(@PathVariable Long userId) {
        return adminService.getUserById(userId);
    }

    @GetMapping("/letters")
    private List<Letter> getLetters() {
        return adminService.getLetters();
    }

    @GetMapping("/letters/{userId}")
    private List<Letter> getLettersByUser(@PathVariable Long userId) {
        return adminService.getLettersByUser(userId);
    }
}
