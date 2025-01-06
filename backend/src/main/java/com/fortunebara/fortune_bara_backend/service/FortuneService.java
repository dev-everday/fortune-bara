package com.fortunebara.fortune_bara_backend.service;

import com.fortunebara.fortune_bara_backend.domain.DailyLetter;
import com.fortunebara.fortune_bara_backend.repository.DailyLetterRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FortuneService {

    private final DailyLetterRepository dailyLetterRepository;

    public FortuneService(DailyLetterRepository dailyLetterRepository) {
        this.dailyLetterRepository = dailyLetterRepository;
    }

    public DailyLetter getTodayFortune(String userId) {
        LocalDate today = LocalDate.now();
        List<DailyLetter> letters = dailyLetterRepository.findByUserIdAndDate(userId, today);

        if (letters.isEmpty()) {
            throw new RuntimeException("No fortune found for today!");
        }

        return letters.get(0);
    }
}