package com.onedirect.todo.controller;

import com.onedirect.todo.dto.UsersDto;
import com.onedirect.todo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public UsersDto addUser(@RequestBody UsersDto usersDto){ return userService.addUser(usersDto); }

    @GetMapping("/all")
    public List<UsersDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UsersDto getUserById(@PathVariable("id") int id){
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    public UsersDto updateUser(@PathVariable("id") int id, @RequestBody UsersDto usersDto){ return userService.updateUser(id, usersDto); }

    @DeleteMapping("/{id}")
    public UsersDto deleteUser(@PathVariable("id") int id){
        return userService.deleteUser(id);
    }

}
