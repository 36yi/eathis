package com.example.eathis.controller;

import com.example.eathis.Entity.user;
import com.example.eathis.service.UserRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/users") // API 엔드포인트
public class DBController {

    @Autowired
    private UserRepository userRepository;

    // 1. 모든 사용자 조회
    @GetMapping
    public List<user> getAllUsers() {
        return userRepository.findAll();
    }

    // 2. 특정 사용자 조회
    @GetMapping("/{id}")
    public user getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    // 3. 사용자 추가
    @PostMapping
    public user createUser(@RequestBody user user) {
        return userRepository.save(user);
    }

    // 4. 사용자 수정
    @PutMapping("/{id}")
    public user updateUser(@PathVariable Long id, @RequestBody user userDetails) {
        user user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        user.setName(userDetails.getName());
        user.setAllergies(userDetails.getAllergies());
        user.setFavoriteRestaurants(userDetails.getFavoriteRestaurants());

        return userRepository.save(user);
    }

    // 5. 사용자 삭제
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        user user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        userRepository.delete(user);
        return "User deleted with id: " + id;
    }
}
