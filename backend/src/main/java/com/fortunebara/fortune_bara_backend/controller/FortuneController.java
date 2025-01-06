package com.fortunebara.fortune_bara_backend.controller;

import com.fortunebara.fortune_bara_backend.domain.DailyLetter;
import com.fortunebara.fortune_bara_backend.service.FortuneService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fortune")
public class FortuneController {

    private final FortuneService fortuneService;

    public FortuneController(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @GetMapping("/today")
    public DailyLetter getTodayFortune(@RequestParam String userId) {
        return fortuneService.getTodayFortune(userId);
    }
}