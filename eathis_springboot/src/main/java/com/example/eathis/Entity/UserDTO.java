package com.example.eathis.Entity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {
    private Long id;
    private String name;
    private List<String> allergies;
    private List<String> favoriteRestaurants;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAllergies() {
        return cleanArray(allergies);
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    public List<String> getFavoriteRestaurants() {
        return cleanArray(favoriteRestaurants);
    }

    public void setFavoriteRestaurants(List<String> favoriteRestaurants) {
        this.favoriteRestaurants = favoriteRestaurants;
    }
    private List<String> cleanArray(List<String> rawArray) {
        if (rawArray == null) return List.of();
        return rawArray.stream()
                .map(item -> item.replaceAll("[{}\"]", "").trim()) // { } " 제거
                .flatMap(item -> Arrays.stream(item.split(","))) // 쉼표로 분리
                .map(String::trim) // 공백 제거
                .collect(Collectors.toList());
    }
}
