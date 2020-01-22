package com.onedirect.todo.builder;

import com.onedirect.todo.dto.UsersDto;
import com.onedirect.todo.entities.Tasks;
import com.onedirect.todo.entities.Users;
import com.onedirect.todo.exceptions.ValidationException;

import java.util.ArrayList;

public class UsersBuilder {
    public UsersDto getUsersDto(Users users){
        UsersDto usersDto = new UsersDto();
        usersDto.setId(users.getId());
        usersDto.setName(users.getName());
        usersDto.setEmail(users.getEmail());
        usersDto.setPassword(users.getPassword());
        return usersDto;
    }

    public Users getUsers(UsersDto usersDto){
        if(usersDto.getName()==null)
            throw new ValidationException("empty name");
        if(usersDto.getEmail()==null)
            throw new ValidationException("emapty email");
        if(usersDto.getPassword()==null)
            throw new ValidationException("empty password");
        Users users = new Users();
        users.setId(usersDto.getId());
        users.setName(usersDto.getName());
        users.setEmail(usersDto.getEmail());
        users.setPassword(usersDto.getPassword());
        users.setTasks(new ArrayList<Tasks>());
        return users;
    }
}
