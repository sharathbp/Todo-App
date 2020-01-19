package com.onedirect.todo.repositories;

import com.onedirect.todo.entities.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users, Integer> {
}
