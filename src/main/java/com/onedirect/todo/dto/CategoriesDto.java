package com.onedirect.todo.dto;

import com.onedirect.todo.entities.Categories;

public class CategoriesDto {
    private Integer id;
    private String category;

    public CategoriesDto() {
    }

    public CategoriesDto(int id, String category) {
        this.id = id;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
