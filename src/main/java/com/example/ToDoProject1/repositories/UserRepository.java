package com.example.ToDoProject1.repositories;


import com.example.ToDoProject1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM users WHERE login = ?", nativeQuery = true)
    User findByLogin(String Login);
}
