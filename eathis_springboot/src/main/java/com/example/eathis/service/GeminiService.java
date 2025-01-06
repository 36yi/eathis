package com.example.eathis.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GeminiService {

    private final RestTemplate restTemplate;

    @Value("${gemini.api.key}") // application.properties에서 API 키 읽기
    private String apiKey;

    private static final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent";


    public GeminiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String generateContent(ArrayList<String> allergies, ArrayList<String> favorite){
        String url = API_URL + "?key=" + apiKey;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, Object> textMap = new HashMap<>();
        String promptText = "한국말로 대답해라 니는 메뉴 한개만 대답하는거다 ";
        promptText += "못 먹는 음식은";
        for (String food:allergies)
            promptText += " " + food + ",";
        promptText += "이것들이 있고 ";

        promptText += "선호하는 식당은 ";
        for (String restaurants:favorite)
            promptText += " " + restaurants + ",";
        promptText += "이것들이 있어 이 정보들을 바탕으로 대답해줘 메뉴 딱 한개 ";
        System.out.println(promptText);
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
