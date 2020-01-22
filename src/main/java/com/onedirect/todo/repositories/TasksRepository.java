package com.onedirect.todo.repositories;

import com.onedirect.todo.entities.Tasks;
import com.onedirect.todo.entities.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepository extends CrudRepository<Tasks, Integer> {
    public Tasks findAllTasksByUser(Users user);
}
