package com.example.ToDoProject1.repositories;

import com.example.ToDoProject1.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TasksRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByUserId(Long id);
}
