package com.onedirect.todo.controller;

import com.onedirect.todo.dto.UsersDto;
import com.onedirect.todo.entities.Users;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @GetMapping("/all")
    public void getAllUsers(){

    }

    @GetMapping("/{id}")
    public UsersDto getUserById(@PathVariable("id") int id){
        return new UsersDto();
    }

}
