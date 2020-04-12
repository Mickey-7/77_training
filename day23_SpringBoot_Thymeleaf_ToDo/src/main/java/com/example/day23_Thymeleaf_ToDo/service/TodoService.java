package com.example.day23_Thymeleaf_ToDo.service;

import com.example.day23_Thymeleaf_ToDo.dao.TodoDAO;
import com.example.day23_Thymeleaf_ToDo.domain.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoDAO todoDAO;
    public TodoService(TodoDAO todoDAO){
        this.todoDAO=todoDAO;
    }

    public void addTodo(Todo todo){
        System.out.println("Service addTodo");
        todoDAO.addTodo(todo);
    }

    public List<Todo> getAllTodo(){
        System.out.println("Service getAllTodo");
        return todoDAO.getAllTodo();
    }

    public void deleteTodo(String title){
        System.out.println("Service deleteTodo");
        todoDAO.deleteTodo(title);
    }

    public void markAsTrue(String title){
        System.out.println("Service markAsTrue");
        todoDAO.markAsTrue(title);
    }
}
