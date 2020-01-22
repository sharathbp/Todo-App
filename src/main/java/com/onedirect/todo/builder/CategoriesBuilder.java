package com.onedirect.todo.builder;

import com.onedirect.todo.dto.CategoriesDto;
import com.onedirect.todo.entities.Categories;
import com.onedirect.todo.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoriesBuilder {
    @Autowired
    private CategoriesRepository categoriesRepository;

    public CategoriesDto getCategoriesDto(Categories categories){
        CategoriesDto categoriesDto = new CategoriesDto();
        categoriesDto.setId(categories.getId());
        categoriesDto.setCategory(categories.getCategory());
        return categoriesDto;
    }

    public Categories getCategories(CategoriesDto categoriesDto){
        Categories categories = categoriesRepository.findById(categoriesDto.getId()).orElse(null);
        categories.setId(categoriesDto.getId());
        categories.setCategory(categoriesDto.getCategory());
        return categories;
    }
}
