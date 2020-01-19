package com.onedirect.todo.controller;

import com.onedirect.todo.dto.CategoriesDto;
import com.onedirect.todo.entities.Categories;
import com.onedirect.todo.repositories.CategoriesRepository;
import com.onedirect.todo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/category")
public class CategoryController {
    @Autowired
    private CategoriesRepository categoriesRepository;
    private CategoryService categoryService = new CategoryService();

    @GetMapping("/all")
    public Iterable<Categories> getCategories(){
        return categoriesRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Categories> getCategoryById(@PathVariable("id") int id){
        return categoriesRepository.findById(id);
    }
}
