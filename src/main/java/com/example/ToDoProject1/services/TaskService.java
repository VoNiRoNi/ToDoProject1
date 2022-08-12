package com.example.ToDoProject1.services;

import com.example.ToDoProject1.models.Task;
import com.example.ToDoProject1.models.User;
import com.example.ToDoProject1.repositories.TasksRepository;
import com.example.ToDoProject1.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskService {
    private final UserRepository userRepository;
    private final TasksRepository tasksRepository;

    public void addTasks(Task task, User user)
    {
        tasksRepository.save(task);
        userRepository.save(user);
    }

    public List<Task> getAllTask(User user)
    {
        return tasksRepository.findAllByUserId(user.getId());
    }


}
