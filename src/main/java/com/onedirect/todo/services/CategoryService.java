package com.onedirect.todo.services;

import com.onedirect.todo.dto.CategoriesDto;
import com.onedirect.todo.entities.Categories;
import com.onedirect.todo.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    @Autowired
    private CategoriesRepository categoriesRepository;

    public List<CategoriesDto> getAllCategories(){
        Iterable<Categories> categories = categoriesRepository.findAll();
        List<CategoriesDto> categoriesDtos = new ArrayList<>();
        for (Categories c:categories) {
            CategoriesDto categoriesDto = new CategoriesDto();
            categoriesDto.setId(c.getId());
            categoriesDto.setCategory(c.getCategory());
            categoriesDtos.add(categoriesDto);
        }
        System.out.println(categoriesDtos);
        return categoriesDtos;
    }
}
