package com.example.day23_Thymeleaf_ToDo.dao;

import com.example.day23_Thymeleaf_ToDo.domain.Todo;
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
        System.out.println("DAO addTodo");
    }

    @Override
    public List<Todo> getAllTodo() {
        System.out.println("DAO getAllTodo");
        return todoList;
    }

    @Override
    public void deleteTodo(String title) {
        Optional.ofNullable(todoList)
                .orElse(Collections.emptyList())
                .removeIf(todo -> todo.getTitle().equals(title));
        System.out.println("DAO deleteTodo");
    }

    @Override
    public void markAsTrue(String title) {
        for (int i = 0; i < todoList.size(); i++) {
            if (todoList.get(i).getTitle().equals(title)){
                todoList.get(i).setStatus(true);
                todoList.get(i).setDateUpdated(LocalDateTime.now());
            }
        }
        System.out.println("DAO updateTodo");
    }
}
