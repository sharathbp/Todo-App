package com.onedirect.todo.dao;

import com.onedirect.todo.entities.Tasks;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class TaskDaoImpl {

    @Autowired
    private EntityManager entityManager;

    public Tasks addTasks(Tasks task){
        Session session = entityManager.unwrap(Session.class);
        session.beginTransaction();
        session.merge(task);
        session.getTransaction().commit();
        session.close();
    }
}
