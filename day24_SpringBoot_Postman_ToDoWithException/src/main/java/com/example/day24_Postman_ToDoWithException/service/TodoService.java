package com.example.day24_Postman_ToDoWithException.service;

import com.example.day24_Postman_ToDoWithException.dao.TodoDAO;
import com.example.day24_Postman_ToDoWithException.domain.Todo;
import com.example.day24_Postman_ToDoWithException.exception.DuplicateIdException;
import com.example.day24_Postman_ToDoWithException.exception.IdMustExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoDAO todoDAO;
    public TodoService(TodoDAO todoDAO){
        this.todoDAO = todoDAO;
    }

    public void addTodo(Todo todo){
        //iterating on getTodo() output method
        for (Todo repeatTodo : getTodo()){
            if (repeatTodo.getId().equals(todo.getId())){
                throw new DuplicateIdException();
            }
        }
        todoDAO.addTodo(todo);

    }

    public List<Todo> getTodo(){
        return todoDAO.getTodo();
    }

    public void deleteTodo(Long id){
        //creating optional Todo object which wil return boolean if id is found
        Optional<Todo> optionalTodo =  Optional.ofNullable(todoDAO.getTodoId(id));
        //.isPresent() -> output : boolean
        if (!optionalTodo.isPresent()){
            throw new IdMustExistException();
        }
        todoDAO.deleteTodo(id);
    }

    public void markTodo(Long id){
        //creating optional Todo object which wil return boolean if id is found
        Optional<Todo> optionalTodo =  Optional.ofNullable(todoDAO.getTodoId(id));
        //.isPresent() -> output : boolean
        if (!optionalTodo.isPresent()){
            throw new IdMustExistException();

        }
        todoDAO.markTodo(id);
    }

    public void updateTodo(Long id, Todo todo){
        //creating optional Todo object which wil return boolean if id is found
        Optional<Todo> optionalTodo =  Optional.ofNullable(todoDAO.getTodoId(id));
        //.isPresent() -> output : boolean
        if (!optionalTodo.isPresent()){
            throw new IdMustExistException();

        }
        todoDAO.updateTodo(id,todo);
    }


}
