package com.example.ToDoProject1.controllers;

import com.example.ToDoProject1.models.Task;
import com.example.ToDoProject1.models.User;
import com.example.ToDoProject1.repositories.UserRepository;
import com.example.ToDoProject1.services.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ToDoMainController {
    private final TaskService taskService;
    private final UserRepository userRepository;
    public User user = new User();

    @GetMapping("/registration")
    public String registration()
    {
        return "registration";
    }

    @PostMapping("/registration")
    public String  processUserRegistration(@RequestParam(value = "username") String login,
                                           @RequestParam(value = "password") String password,
                                           @RequestParam(value = "email") String email)
    {
        log.info("QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ");
        userRepository.save(new User(login,password,email));
        return "redirect:/login";
    }


    @GetMapping("/login")
    public String logIn() {
        return "login";
    }

    @PostMapping("/login_pre")
    public String loginPost(@RequestParam(value = "username") String login, @RequestParam(value = "password") String password)
    {
        user = userRepository.findByLogin(login);
        return "redirect:/";
    }



    @GetMapping("/")
    public String mainToDo(Model model) {
        model.addAttribute("tasks", taskService.getAllTask(user));
        model.addAttribute("user", user);
        return "mainScreen";
    }


    @PostMapping("/addTask")
    public String addTaskToUser(@RequestParam(value = "title", defaultValue = "unknown") String title,
                                @RequestParam(value = "description", defaultValue = "") String description,
                                @RequestParam(value = "comment", defaultValue = "") String comment,
                                @RequestParam(value = "status", defaultValue = "unknown") String status) {
        Task task = new Task(title, description, status, comment, user);
        taskService.addTasks(task, user);
        return "redirect:/home";
    }
}


