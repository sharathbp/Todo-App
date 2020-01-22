package com.onedirect.todo.bean;

import com.onedirect.todo.builder.CategoriesBuilder;
import com.onedirect.todo.builder.TasksBuilder;
import com.onedirect.todo.builder.UsersBuilder;
import com.onedirect.todo.validator.CategoriesValidator;
import com.onedirect.todo.validator.TasksValidator;
import com.onedirect.todo.validator.UsersValidator;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidatorBean {
    @Bean
    public UsersValidator getUsersValidator(){
        return new UsersValidator();
    }

    @Bean
    public CategoriesValidator getCategoryValidator(){
        return new CategoriesValidator();
    }
    @Bean
    public TasksValidator getTasksValidator(){
        return new TasksValidator();
    }

    @Bean
    public UsersBuilder getUsersBuilder(){
        return new UsersBuilder();
    }
    @Bean
    public TasksBuilder getTasksBuilder(){
        return new TasksBuilder();
    }
    @Bean
    public CategoriesBuilder getCategoriesBuilder(){
        return new CategoriesBuilder();
    }
}
