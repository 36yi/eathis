package com.example.eathis.controller;

import com.example.eathis.service.GeminiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/api")
public class GeminiController {

    private final GeminiService geminiService;

    @Autowired
    public GeminiController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @GetMapping("/symbols")
    public String getSymbols() {
        return geminiService.getSymbols();
    }

    @PostMapping("/generate")
    public void generateContent(@RequestBody Map<String, int[]> request) { //배열이 올거라 가정하자
        int[] members = (int[])request.get("members");
        for (int member : members) {
            System.out.println(member);
        }
//        return geminiService.generateContent(request.get());
    }
}
