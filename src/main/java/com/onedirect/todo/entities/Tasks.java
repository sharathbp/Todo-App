package com.onedirect.todo.entities;

import com.onedirect.todo.enums.PriorityEnum;
import com.onedirect.todo.enums.StatusEnum;

import javax.persistence.*;
import java.util.Date;

@Entity
@TableGenerator(name="userId", initialValue=0, allocationSize = 100)
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "userId")
    private Integer id;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="category_id")
    private Categories category;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="user_id")
    private Users user;
    private String title;
    private String description;
    private StatusEnum status;
    private PriorityEnum priority;
    @Temporal(TemporalType.DATE)
    private Date due_date;

    public Tasks() {
    }

    public Tasks(Categories category, Users user, String title, String description, StatusEnum status, PriorityEnum priority, Date due_date) {
        this.category = category;
        this.user = user;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.due_date = due_date;
    }

    public Tasks(String title, String description, StatusEnum status, PriorityEnum priority, Date due_date) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.due_date = due_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public PriorityEnum getPriority() {
        return priority;
    }

    public void setPriority(PriorityEnum priority) {
        this.priority = priority;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "id=" + id +
                ", category=" + category +
                ", user=" + user +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", priority=" + priority +
                ", due_date=" + due_date +
                '}';
    }
}
