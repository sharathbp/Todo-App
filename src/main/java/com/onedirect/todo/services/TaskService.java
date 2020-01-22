package com.onedirect.todo.services;

import com.onedirect.todo.builder.TasksBuilder;
import com.onedirect.todo.dto.TasksDto;
import com.onedirect.todo.entities.Categories;
import com.onedirect.todo.entities.Tasks;
import com.onedirect.todo.entities.Users;
import com.onedirect.todo.enums.StatusEnum;
import com.onedirect.todo.exceptions.ValidationException;
import com.onedirect.todo.repositories.TasksRepository;
import com.onedirect.todo.validator.CategoriesValidator;
import com.onedirect.todo.validator.TasksValidator;
import com.onedirect.todo.validator.UsersValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TaskService {
    @Autowired
    private TasksRepository tasksRepository;
    @Autowired
    private UsersValidator usersValidator;
    @Autowired
    private CategoriesValidator categoriesValidator;
    @Autowired
    private TasksValidator tasksValidator;
    @Autowired
    private TasksBuilder tasksBuilder;
    static Logger logger = Logger.getLogger(TaskService.class.getName());

    public TasksDto addTasks(TasksDto tasksDto){
        Users users = usersValidator.validateUser(tasksDto.getUser_id());
        Categories categories = categoriesValidator.validateCategory(tasksDto.getCategory_id());
        tasksValidator.priorityValidator(tasksDto.getPriority());
        tasksValidator.statusValidator(tasksDto.getStatus());
        tasksValidator.dateValidator(tasksDto.getDue_date());
        Tasks tasks = tasksBuilder.getTasks(tasksDto);
        tasks.setUser(users);
        tasks.setCategory(categories);
        tasksRepository.save(tasks);
        logger.debug("TaskAdded" + tasks);
        return tasksBuilder.getTasksDto(tasks);
    }

    public TasksDto getTasks(int id){
        Tasks tasks = tasksValidator.tasksValidator(id);
        logger.debug("FetchTask: " + tasks);
        return tasksBuilder.getTasksDto(tasks);
    }

    public TasksDto getTaskByUser(int id){
        Users users = usersValidator.validateUser(id);
        Tasks tasks = tasksRepository.findAllTasksByUser(users);
        logger.debug("FetchTaskOfUser: " + tasks);
        return tasksBuilder.getTasksDto(tasks);
    }

    public TasksDto updateTasks(int id, TasksDto tasksDto){
        Tasks tasks = tasksRepository.findById(id).orElse(null);
        if(tasks==null)
            throw new ValidationException("Task not found");
        Categories categories = categoriesValidator.validateCategory(tasks.getCategory().getId());
        if(tasksDto.getTitle()!=null)
            tasks.setTitle(tasksDto.getTitle());
        if(tasksDto.getDescription()!=null)
            tasks.setDescription(tasksDto.getDescription());
        if(tasksDto.getPriority()!=null)
            tasks.setPriority(tasksDto.getPriority());
        if(tasksDto.getStatus()!=null)
            tasks.setStatus(tasksDto.getStatus());
        if(tasksDto.getDue_date()!=null)
            tasks.setDue_date(tasks.getDue_date());
        tasksRepository.save(tasks);
        logger.debug("updateTask: "+tasks);
        return tasksBuilder.getTasksDto(tasks);
    }

    public TasksDto deleteTask(int id) {
        Tasks tasks = tasksRepository.findById(id).orElse(null);
        if(tasks==null)
            throw new ValidationException("Task not found");
        if(tasks.getStatus()== StatusEnum.DELETED)
            throw new ValidationException("User not found");
        tasks.setStatus(StatusEnum.DELETED);
        tasksRepository.save(tasks);
        logger.debug("deleteTask: " + tasks);
        return tasksBuilder.getTasksDto(tasks);
    }
}
