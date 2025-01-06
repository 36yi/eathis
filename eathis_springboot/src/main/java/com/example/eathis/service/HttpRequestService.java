package com.example.eathis.service;

import com.example.eathis.Entity.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class HttpRequestService {

    private final RestTemplate restTemplate;

    public HttpRequestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserDTO sendGetRequest(int number) {
        // 요청을 보낼 URL
        String url = "http://localhost:8080/users/" + number;
//        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return restTemplate.getForObject(url, UserDTO.class); //String.class는 HTTP 응답 데이터 타입 지정

    }
}
