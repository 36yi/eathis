package com.example.eathis.service;

import com.example.eathis.Entity.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<user, Long> {
    // 필요한 경우 커스텀 메서드를 추가 가능
}
