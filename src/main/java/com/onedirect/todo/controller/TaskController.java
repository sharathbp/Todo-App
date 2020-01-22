package com.onedirect.todo.controller;

import com.onedirect.todo.dto.TasksDto;
import com.onedirect.todo.entities.Categories;
import com.onedirect.todo.entities.Tasks;
import com.onedirect.todo.entities.Users;
import com.onedirect.todo.enums.PriorityEnum;
import com.onedirect.todo.enums.StatusEnum;
import com.onedirect.todo.repositories.CategoriesRepository;
import com.onedirect.todo.repositories.TasksRepository;
import com.onedirect.todo.repositories.UsersRepository;
import com.onedirect.todo.services.TaskService;
import com.onedirect.todo.services.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.beans.Transient;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/task")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<String> getStatus(){
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @PostMapping
    public TasksDto addTask(@RequestBody TasksDto tasksDto){
        return taskService.addTasks(tasksDto);
    }

    @GetMapping("/tid/{id}")
    public TasksDto getTask(@PathVariable("id") int id){
        return taskService.getTasks(id);
    }

    @GetMapping("/uid/{id}")
    public List<TasksDto> getAllTasks(@PathVariable("id") int id){
        return userService.getTasksByUser(id);
    }

    @PutMapping("/{id}")
    public TasksDto updateTask(@PathVariable("id") int id, @RequestBody TasksDto tasksDto){
        return taskService.updateTasks(id, tasksDto);
    }
    @DeleteMapping("/{id}")
    public TasksDto deleteTask(@PathVariable("id") int id){
        return taskService.deleteTask(id);
    }

}
