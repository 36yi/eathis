package com.example.eathis.controller;

import com.example.eathis.Entity.UserDTO;
import com.example.eathis.service.GeminiService;
import com.example.eathis.service.HttpRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class GeminiController {
    private final HttpRequestService httpRequestService;
    private final GeminiService geminiService;

    @Autowired
    public GeminiController(HttpRequestService httpRequestService, GeminiService geminiService) {
        this.httpRequestService = httpRequestService;
        this.geminiService = geminiService;
    }

    @GetMapping("/symbols")
    public String getSymbols() {
        return geminiService.getSymbols();
    }

    @PostMapping("/generate")
    public String generateContent(@RequestBody Map<String, int[]> request) { //배열이 올거라 가정하자
        int[] members = (int[])request.get("members");
        ArrayList<String> allergies = new ArrayList<String>();
        ArrayList<String> favorite = new ArrayList<String>();
        UserDTO response = new UserDTO();
        for (int member : members) {
            response = httpRequestService.sendGetRequest(member);
            allergies.addAll(response.getAllergies());
            favorite.addAll(response.getFavoriteRestaurants());
        }
        System.out.println(allergies);
        System.out.println(favorite);
        return geminiService.generateContent(allergies, favorite);
    }
}
