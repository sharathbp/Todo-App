package com.onedirect.todo.validator;

import com.onedirect.todo.dto.CategoriesDto;
import com.onedirect.todo.entities.Categories;
import com.onedirect.todo.exceptions.ValidationException;
import com.onedirect.todo.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.validation.annotation.Validated;

public class CategoriesValidator {
    @Autowired
    private CategoriesRepository categoriesRepository;

    public Categories validateCategory(int id){
        Categories categories = categoriesRepository.findById(id).orElse(null);
        if(categories==null)
            throw new ValidationException("Invalid category");
        return categories;
    }

    public void CategoryExists(CategoriesDto categoriesDto){
        if(categoriesRepository.findAllByCategory(categoriesDto.getCategory())!=null)
            throw new ValidationException("category already exists");
    }
}
