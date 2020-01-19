package com.onedirect.todo.repositories;

import com.onedirect.todo.entities.Categories;
import org.springframework.data.repository.CrudRepository;

public interface CategoriesRepository extends CrudRepository<Categories, Integer> {
}
