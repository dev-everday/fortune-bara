package com.fortunebara.fortune_bara_backend.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "daily_letters")
public class DailyLetter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userId;

    private LocalDate date;
    private String message;
    private String luckyColor;
    private String luckyItem;
    private Integer luckyNumber;
}
