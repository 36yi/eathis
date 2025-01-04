package com.example.eathis.controller;

import com.example.eathis.service.GeminiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class GeminiController {

    private final GeminiService geminiService;

    @Autowired
    public GeminiController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @GetMapping("/api/symbols")
    public String getSymbols() {
        return geminiService.getSymbols();
    }

    @PostMapping("/generate")
    public String generateContent(@RequestBody String prompt) {
        return geminiService.generateContent(prompt);
    }
}
