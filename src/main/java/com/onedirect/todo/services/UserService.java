package com.onedirect.todo.services;

import com.onedirect.todo.builder.TasksBuilder;
import com.onedirect.todo.builder.UsersBuilder;
import com.onedirect.todo.dto.TasksDto;
import com.onedirect.todo.dto.UsersDto;
import com.onedirect.todo.entities.Tasks;
import com.onedirect.todo.entities.Users;
import com.onedirect.todo.exceptions.ValidationException;
import com.onedirect.todo.repositories.UsersRepository;
import com.onedirect.todo.validator.UsersValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UsersValidator usersValidator;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private UsersBuilder usersBuilder;
    @Autowired
    private TasksBuilder tasksBuilder;

    public UsersDto addUser(UsersDto usersDto){
        Users users = usersBuilder.getUsers(usersDto);
        users.setStatus(1);
        if(usersValidator.findUserByEmail(users.getEmail()))
            throw new ValidationException("user already exist");
        usersRepository.save(users);

        usersRepository.save(users);
        return usersDto;
    }

    public List<UsersDto> getAllUsers(){
        Iterable<Users> usersIterable = usersRepository.findAll();
        ArrayList<UsersDto> usersDtos = new ArrayList<>();
        for(Users user: usersIterable){
            usersDtos.add(usersBuilder.getUsersDto(user));
        }
        return usersDtos;
    }

    public UsersDto getUser(int id){
        Users user = usersRepository.findById(id).orElse(null);
        if(user==null){
            throw new ValidationException("user doesn't exist");
        }
        if(user.getStatus()==0){
            throw new ValidationException("user is inactive");
        }
        return usersBuilder.getUsersDto(user);
    }

    public UsersDto updateUser(int id, UsersDto usersDto){
        Users user = usersRepository.findById(id).orElse(null);
        if(user==null)
            throw new ValidationException("invalid user id " + id);
        if(usersValidator.findUserByEmail(usersDto.getEmail()) && usersDto.getEmail()!=null)
            throw new ValidationException("email already in use");
        if(usersDto.getName()!=null)
            user.setName(usersDto.getName());
        if(usersDto.getEmail()!=null)
            user.setEmail(usersDto.getEmail());
        if(usersDto.getPassword()!=null)
            user.setPassword(usersDto.getPassword());
        usersRepository.save(user);
        return usersBuilder.getUsersDto(user);
    }

    public UsersDto deleteUser(int id){
        Users user = usersRepository.findById(id).orElse(null);
        if(user==null)
            throw new ValidationException("invalid user id");
        user.setStatus(0);
        usersRepository.save(user);
        return usersBuilder.getUsersDto(user);
    }

    public List<TasksDto> getTasksByUser(int id){
        Users user = usersRepository.findById(id).orElse(null);
        if(user==null)
            throw new ValidationException("invalid user id");
        Collection<Tasks> tasks =  user.getTasks();
        List<TasksDto> tasksDtos = new ArrayList<>();
        for(Tasks task:tasks){
            tasksDtos.add(tasksBuilder.getTasksDto(task));
        }
        return tasksDtos;
    }

}
