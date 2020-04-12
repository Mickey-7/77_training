package com.example.day23_Thymeleaf_ToDo.dao;

import com.example.day23_Thymeleaf_ToDo.domain.Todo;

import java.util.List;

public interface TodoDAO {
    void addTodo(Todo todo);
    List<Todo> getAllTodo();
    void deleteTodo(String title);
    void markAsTrue(String title);
}
