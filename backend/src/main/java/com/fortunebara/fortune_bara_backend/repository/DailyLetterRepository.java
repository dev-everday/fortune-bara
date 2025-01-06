package com.fortunebara.fortune_bara_backend.repository;

import com.fortunebara.fortune_bara_backend.domain.DailyLetter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DailyLetterRepository extends JpaRepository<DailyLetter, Long> {
    List<DailyLetter> findByUserIdAndDate(String userId, LocalDate date);
}
