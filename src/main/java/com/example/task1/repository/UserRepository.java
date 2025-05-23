package com.example.task1.repository;


import com.example.task1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Tìm user theo email
    Optional<User> findByEmail(String email);

    // Kiểm tra email đã tồn tại chưa
    boolean existsByEmail(String email);

    // Tìm user theo họ tên (chứa từ khóa)
    java.util.List<User> findByFullNameContainingIgnoreCase(String fullName);
}