package com.onedirect.todo.entities;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity
@TableGenerator(name="userId", initialValue=0, allocationSize = 100)
public class Users {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator = "userId")
    private int id;
    private String name;
    private String email;
    private String password;
    @OneToMany(cascade = {CascadeType.MERGE}, mappedBy = "user")
    private Collection<Tasks> tasks = new ArrayList<Tasks>();

    public Users() {
    }

    public Users(int id, String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Users(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Users(String name, String email, String password, Set<Tasks> tasks) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.tasks = tasks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(Collection<Tasks> tasks) {
        this.tasks = tasks;
    }
}
