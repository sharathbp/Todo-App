package com.onedirect.todo.entities;

import javax.persistence.*;

@Entity
@TableGenerator(name="categoryId", initialValue=0, allocationSize = 100)
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "categoryId")
    private int id;
    private String category;
    private int present;

    public Categories() {
    }

    public Categories(String category) {
        this.category = category;
    }

    public Categories(int id, String category) {
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

    public int getPresent() {
        return present;
    }

    public void setPresent(int present) {
        this.present = present;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "id=" + id +
                ", category='" + category + '\'' +
                '}';
    }
}
