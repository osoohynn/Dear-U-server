package com.example.dearu.domain.letter.repository;

import com.example.dearu.domain.letter.domian.Letter;
import com.example.dearu.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LetterRepository extends JpaRepository<Letter, Long> {
    List<Letter> findByFromUser(User fromUser);

    List<Letter> findByToUser(User toUser);
}
