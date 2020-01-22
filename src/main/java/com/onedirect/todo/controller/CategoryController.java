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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/category")
public class CategoryController {
    @Autowired
    private CategoriesRepository categoriesRepository;
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public CategoriesDto addCategory(@RequestBody CategoriesDto categoriesDto){ return categoryService.addCategory(categoriesDto); }

    @GetMapping("/all")
    public List<CategoriesDto> getCategories(){ return categoryService.getAllCategories(); }

    @GetMapping("/{id}")
    public CategoriesDto getCategoryById(@PathVariable("id") int id){ return categoryService.getCategory(id); }

    @PutMapping("/{id}")
    public CategoriesDto updateCategories(int id, @RequestBody CategoriesDto categoriesDto){ return categoryService.updateCategory(id, categoriesDto); }

    @DeleteMapping("/{id}")
    public CategoriesDto deleteCategories(int id){ return categoryService.deleteCategory(id); }
}
