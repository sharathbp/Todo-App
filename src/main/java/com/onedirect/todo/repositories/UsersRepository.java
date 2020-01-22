package com.onedirect.todo.repositories;

import com.onedirect.todo.entities.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users, Integer> {
    public Users findUsersByEmail(String email);
}
