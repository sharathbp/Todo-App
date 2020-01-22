package com.onedirect.todo.validator;

import com.onedirect.todo.entities.Users;
import com.onedirect.todo.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

import javax.validation.ValidationException;
import javax.validation.executable.ValidateOnExecution;


public class UsersValidator {
    @Autowired
    private UsersRepository usersRepository;

    public Users validateUser(int id){
        Users users = usersRepository.findById(id).orElse(null);
        if(users==null)
            throw new ValidationException("user not found");
        if(users.getStatus()==0)
            throw new ValidationException("Inactive user");
        return users;
    }

    public boolean findUserByEmail(String email){
        if(usersRepository.findUsersByEmail(email)==null)
            return false;
        return true;
    }
}
