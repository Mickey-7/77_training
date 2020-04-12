package com.example.day24_Postman_ToDoWithException.controller;

import com.example.day24_Postman_ToDoWithException.domain.Todo;
import com.example.day24_Postman_ToDoWithException.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("todos")
public class TodoController {

    @Autowired
    private TodoService todoService;
    public TodoController(TodoService todoService){
        this.todoService=todoService;
    }

    //create API controller for addTodo
    @PostMapping
    public void addTodo(@RequestBody  Todo todo){
        //@RequestBody annotation binds request body to method parameters
        //usually use for @PostMapping & @PutMapping
        todoService.addTodo(todo);
    }

    //create API controller for viewTodo
    @GetMapping
    public List<Todo> viewTodo(){
        return todoService.getTodo();
    }

    //create API controller for deleteTodo
    @DeleteMapping("/delete/{id}")
    public void deleteTodo(@PathVariable Long id){
        //@PathVariable is a Spring annotation which indicates that a
        //method parameter should be bound to a URI template variable.
        //use for method that needs id like delete and update and patch
        todoService.deleteTodo(id);
    }

    @PatchMapping("/mark/{id}")
    //@PathMapping is use for updating one field only
    public void markTodo(@PathVariable Long id){
        //@PathVariable is a Spring annotation which indicates that a
        //method parameter should be bound to a URI template variable.
        //use for method that needs id like delete and update and patch
        todoService.markTodo(id);
    }

    //create API controller for updateTodo
    @PutMapping("/update/{id}")
    public void updateTodo(@PathVariable Long id, @RequestBody Todo todo){
        //@PathVariable is a Spring annotation which indicates that a
        //method parameter should be bound to a URI template variable.
        //use for method that needs id like delete and update and patch
        //@RequestBody annotation binds request body to method parameters.
        //usually use for @PostMapping & @PutMapping
        todoService.updateTodo(id, todo);
    }

}
