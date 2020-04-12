package com.example.day23_Thymeleaf_ToDo.controller;

import com.example.day23_Thymeleaf_ToDo.domain.Todo;
import com.example.day23_Thymeleaf_ToDo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;
    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    //create a text message to be displayed on home.html using Model
    @GetMapping("homeURL")                                     //for url web browser
    public String home(Model model){
        System.out.println("Controller home");
        model.addAttribute("message","This is Home from Controller");
        return "home";                                      //for home.html file
    }

    //create  controller for addTodo
    //create a ModelMap for todo with @GetMapping
    @GetMapping("addGet")                                          //for url web browser
    public String addTodo(ModelMap modelMap){
        System.out.println("Controller GET addTodo");
        //create a modelMap which will store the fields from addTodo.html
        modelMap.addAttribute("todo",new Todo());
        return "addTodo";                                       //for addTodo.html
    }
    //will be executed after Add Todo is submitted/Clicked
    @PostMapping("addPost")                                     //will be called from addTodo.html
    public String addTodo(Todo todo){
        System.out.println("Controller POST addTodo");
        //invoking todoService
        todoService.addTodo(todo);
        //redirecting to viewGet - @GetMapping of method below   //for url web browser
        return "redirect:/viewGet";
    }

    //create viewGet - will display all todo using ModelMap
    @GetMapping("viewGet")                                      //for url web browse
    public String getAllTodo(ModelMap modelMap){
        System.out.println("Controller GET viewTodo");
        //invoking todoService and storing it on modelMap
        modelMap.addAttribute("todos",todoService.getAllTodo());//notice the attribute name todos will be called on viewTodo.html
        return "viewTodo";                                      //for viewTodo.html
    }

    //create @GetMapping for deleteTodo - no need for @PostMapping like in day22 as we are not manually putting the id on url
    @GetMapping("delete/{title}")                   //for url web browser
    public String deleteTodo(@PathVariable String title){
        System.out.println("Controller GET deleteTodo");
        //invoking todoService
        todoService.deleteTodo(title);
        //redirect to viewGet
        return "redirect:/viewGet";                 //for url web browser

    }

    //create @GetMapping for updateTodo - no need for @PostMapping like in day22 as we are not manually putting the id on url
    @GetMapping("update/{title}")                   //for url web browser
    public String updateTodo(@PathVariable String title){
        System.out.println("Controller GET updateTodo");
        //invoking todoService
        todoService.markAsTrue(title);
        //redirect to viewGet
        return "redirect:/viewGet";                 //for url web browser

    }
}
