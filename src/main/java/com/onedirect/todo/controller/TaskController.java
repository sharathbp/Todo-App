package com.onedirect.todo.controller;

import com.onedirect.todo.entities.Categories;
import com.onedirect.todo.entities.Tasks;
import com.onedirect.todo.entities.Users;
import com.onedirect.todo.enums.PriorityEnum;
import com.onedirect.todo.enums.StatusEnum;
import com.onedirect.todo.repositories.CategoriesRepository;
import com.onedirect.todo.repositories.TasksRepository;
import com.onedirect.todo.repositories.UsersRepository;
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




    @PostMapping("/add")
    public String addTask(@RequestBody Tasks){
        Users user = new Users(403,"ajay", "ajay10@gmail.com", "passwd");
        Categories cat = new Categories(0,"wishlist");
        Tasks task = new Tasks(cat, user,"title2 updated", "desc2 updated", StatusEnum.COMPLETE, PriorityEnum.NO_PRIORITY, new Date());
        user.getTasks().add(task);




        return "Success";
    }

}
