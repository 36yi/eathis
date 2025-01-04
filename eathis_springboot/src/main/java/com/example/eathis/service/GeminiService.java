package com.example.eathis.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GeminiService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${gemini.api.key}") // application.properties에서 API 키 읽기
    private String apiKey;

    private static final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent";

    public String generateContent(String promptText){
        String url = API_URL + "?key=" + apiKey;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, Object> textMap = new HashMap<>();
        textMap.put("text", promptText);

        Map<String, Object> partsMap = new HashMap<>();
        partsMap.put("parts", List.of(textMap));

        Map<String, Object> contentsMap = new HashMap<>();
        contentsMap.put("contents", List.of(partsMap));

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(contentsMap, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                String.class
        );
        return response.getBody();
    }



    public String getSymbols() {
        // Gemini API URL
        String url = "https://api.gemini.com/v1/symbols";


        // HTTP 요청 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey); // API 키 추가
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        // GET 요청 보내기
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        // 응답 반환
        return response.getBody();
    }
}
