package com.onedirect.todo.validator;


import com.onedirect.todo.entities.Tasks;
import com.onedirect.todo.enums.PriorityEnum;
import com.onedirect.todo.enums.StatusEnum;
import com.onedirect.todo.exceptions.ValidationException;
import com.onedirect.todo.repositories.TasksRepository;
import javafx.scene.layout.Priority;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

@Validated
public class TasksValidator {
    @Autowired
    private TasksRepository tasksRepository;
    public void priorityValidator(PriorityEnum i){
        for(PriorityEnum prio: PriorityEnum.values()){
            if(prio==i) {
                return;
            }
        }
        throw new ValidationException("Invalid priority value");
    }
    public void statusValidator(StatusEnum i){
        for(StatusEnum stat: StatusEnum.values()){
            if(stat==i)
                return ;
        }
        throw new ValueException("Invalid status value");
    }
    public void dateValidator(Date date){
        if(date.compareTo(new Date())<0){
            throw new ValidationException("invalid date");
        }
    }

    public Tasks tasksValidator(int id){
        Tasks tasks = tasksRepository.findById(id).orElse(null);
        if(tasks==null)
            throw new ValidationException("task not found");
        return tasks;
    }

}
