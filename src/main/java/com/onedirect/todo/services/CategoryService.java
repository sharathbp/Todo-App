package com.onedirect.todo.services;

import com.onedirect.todo.builder.CategoriesBuilder;
import com.onedirect.todo.dto.CategoriesDto;
import com.onedirect.todo.entities.Categories;
import com.onedirect.todo.exceptions.ValidationException;
import com.onedirect.todo.repositories.CategoriesRepository;
import com.onedirect.todo.validator.CategoriesValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoriesRepository categoriesRepository;
    @Autowired
    private CategoriesValidator categoriesValidator;
    @Autowired
    private CategoriesBuilder categoriesBuilder;

    public List<CategoriesDto> getAllCategories(){
        Iterable<Categories> categories = categoriesRepository.findAll();
        List<CategoriesDto> categoriesDtos = new ArrayList<>();
        for (Categories c:categories) {
            CategoriesDto categoriesDto = new CategoriesDto();
            categoriesDto.setId(c.getId());
            categoriesDto.setCategory(c.getCategory());
            categoriesDtos.add(categoriesDto);
        }
        return categoriesDtos;
    }

    public CategoriesDto addCategory(CategoriesDto categoriesDto) {
        categoriesValidator.CategoryExists(categoriesDto);
        Categories categories = new Categories();
        categories.setCategory(categoriesDto.getCategory());
        categories.setPresent(1);
        categoriesRepository.save(categories);
        return categoriesBuilder.getCategoriesDto(categories);
    }

    public CategoriesDto updateCategory(int id, CategoriesDto categoriesDto){
        Categories categories = categoriesRepository.findById(id).orElse(null);
        if(categories==null)
            throw new ValidationException("Invalid category id");
        categories.setCategory(categoriesDto.getCategory());
        categoriesRepository.save(categories);
        categoriesDto.setId(categories.getId());
        return categoriesDto;
    }

    public CategoriesDto deleteCategory(int id){
        Categories categories = categoriesRepository.findById(id).orElse(null);
        if(categories==null || categories.getPresent()==0)
            throw new ValidationException("invalid id");
        categories.setPresent(0);
        categoriesRepository.save(categories);
        return categoriesBuilder.getCategoriesDto(categories);
    }

    public CategoriesDto getCategory(int id) {
        Categories categories = categoriesRepository.findById(id).orElse(null);
        if(categories==null)
            throw new ValidationException("Invalid id");
        return categoriesBuilder.getCategoriesDto(categories);
    }
}
