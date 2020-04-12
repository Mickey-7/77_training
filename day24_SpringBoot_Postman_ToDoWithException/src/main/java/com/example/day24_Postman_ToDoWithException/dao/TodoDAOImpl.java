package com.example.day24_Postman_ToDoWithException.dao;

import com.example.day24_Postman_ToDoWithException.domain.Todo;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class TodoDAOImpl implements TodoDAO {
    List<Todo> todoList = new ArrayList<>();

    @Override
    public void addTodo(Todo todo) {
        todo.setStatus(false);
        todo.setDateCreated(LocalDateTime.now());
        todoList.add(todo);
    }

    @Override
    public List<Todo> getTodo() {
        return todoList;
    }

    @Override
    public void deleteTodo(Long id) {
        todoList.removeIf(todo -> todo.getId().equals(id));
    }

    @Override
    public void markTodo(Long id){
        for (Todo todo : todoList){
            if (todo.getId().equals(id)){
                todo.setStatus(true);
                todo.setDateUpdated(LocalDateTime.now());
            }
        }
    }

    @Override
    public void updateTodo(Long id, Todo todo) {
        for (Todo oldTodo : todoList){
            if (oldTodo.getId().equals(id)){
                oldTodo.setTitle(todo.getTitle());
                oldTodo.setDescription(todo.getDescription());
                oldTodo.setDateUpdated(LocalDateTime.now());
            }
        }

    }

    @Override
    public Todo getTodoId(Long id) {
        for (Todo todo : todoList){
            if (todo.getId().equals(id)){
                return todo;
            }
        }
        return null;
    }
}
