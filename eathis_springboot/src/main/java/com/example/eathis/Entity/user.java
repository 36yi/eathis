package com.example.eathis.Entity;

import jakarta.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "users") // 실제 테이블 이름으로 변경
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID 자동 증가
    private Long id;
    private String name;

    @Column(columnDefinition = "TEXT") // TEXT 형식
    private String allergies; // 쉼표로 구분된 알레르기 데이터

    @Column(columnDefinition = "TEXT") // TEXT 형식
    private String favoriteRestaurants; // 쉼표로 구분된 레스토랑 데이터

    // 기본 생성자
    public user() {
    }

    // Getter와 Setter
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

    // allergies: 문자열로 저장 및 리스트로 반환
    public List<String> getAllergies() {
        if (allergies == null || allergies.isEmpty()) {
            return List.of();
        }
        return Arrays.asList(allergies.split(","));
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = String.join(",", allergies);

    }

    public List<String> getFavoriteRestaurants() {
        if (favoriteRestaurants == null || favoriteRestaurants.isEmpty()) {
            return List.of();
        }
        return Arrays.asList(favoriteRestaurants.split(","));
    }

    public void setFavoriteRestaurants(List<String> favoriteRestaurants) {
        this.favoriteRestaurants = String.join(",", favoriteRestaurants);
    }
}