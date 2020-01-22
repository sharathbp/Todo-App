package com.onedirect.todo.builder;

import com.onedirect.todo.dto.TasksDto;
import com.onedirect.todo.entities.Tasks;
import com.onedirect.todo.exceptions.ValidationException;
import com.onedirect.todo.repositories.CategoriesRepository;
import com.onedirect.todo.repositories.TasksRepository;
import com.onedirect.todo.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TasksBuilder {
    @Autowired
    private TasksRepository tasksRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private CategoriesRepository categoriesRepository;

    public Tasks getTasks(TasksDto tasksDto){
        if(usersRepository.findById(tasksDto.getUser_id())==null)
            throw new ValidationException("invalid user");
        Tasks tasks = new Tasks();
        tasks.setCategory(categoriesRepository.findById(tasksDto.getCategory_id()).get());
        tasks.setUser(usersRepository.findById(tasksDto.getUser_id()).get());
        tasks.setTitle(tasksDto.getTitle());
        tasks.setDescription(tasksDto.getDescription());
        tasks.setPriority(tasksDto.getPriority());
        tasks.setStatus(tasksDto.getStatus());
        tasks.setDue_date(tasksDto.getDue_date());
        return tasks;
    }

    public TasksDto getTasksDto(Tasks tasks){
        TasksDto tasksDto = new TasksDto();
        tasksDto.setId(tasks.getId());
        tasksDto.setCategory_id(tasks.getCategory().getId());
        tasksDto.setUser_id(tasks.getUser().getId());
        tasksDto.setTitle(tasks.getTitle());
        tasksDto.setDescription(tasks.getDescription());
        tasksDto.setPriority(tasks.getPriority());
        tasksDto.setStatus(tasks.getStatus());
        tasksDto.setDue_date(tasks.getDue_date());
        return tasksDto;
    }
}
