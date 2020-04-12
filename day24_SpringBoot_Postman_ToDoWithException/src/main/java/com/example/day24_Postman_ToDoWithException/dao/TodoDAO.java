package com.example.day24_Postman_ToDoWithException.dao;

import com.example.day24_Postman_ToDoWithException.domain.Todo;

import java.util.List;

public interface TodoDAO {
    void addTodo(Todo todo);
    List<Todo> getTodo();
    void deleteTodo(Long id);
    void markTodo(Long id);
    void updateTodo(Long id, Todo todo);
    //for Exception
    Todo getTodoId(Long id);
}
