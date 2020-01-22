package com.onedirect.todo.repositories;

import com.onedirect.todo.entities.Categories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends CrudRepository<Categories, Integer> {
    public Categories findAllByCategory(String category);
}
