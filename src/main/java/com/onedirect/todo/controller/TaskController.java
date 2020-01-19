package com.onedirect.todo.controller;

import com.onedirect.todo.entities.Categories;
import com.onedirect.todo.entities.Tasks;
import com.onedirect.todo.entities.Users;
import com.onedirect.todo.enums.PriorityEnum;
import com.onedirect.todo.enums.StatusEnum;
import com.onedirect.todo.repositories.CategoriesRepository;
import com.onedirect.todo.repositories.TasksRepository;
import com.onedirect.todo.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.beans.Transient;
import java.util.Date;

@RestController
@RequestMapping("/v1/task")
public class TaskController {
    @Autowired
    private TasksRepository taskRepo;
    @Autowired
    private UsersRepository userRepo;
    @Autowired
    private CategoriesRepository catRepo;

    @GetMapping("/")
    public ResponseEntity<String> getStatus(){
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @PostMapping("/")
    public Tasks addTask(){
        Users user = new Users(203,"ajay", "ajay@gmail.com", "passwd");
        Categories cat = new Categories(0,"wishlist");
        Tasks task = new Tasks(cat, user,"title2", "desc2", StatusEnum.COMPLETE, PriorityEnum.NO_PRIORITY, new Date());
        user.getTasks().add(task);

        return taskRepo.save(task);
    }

}
