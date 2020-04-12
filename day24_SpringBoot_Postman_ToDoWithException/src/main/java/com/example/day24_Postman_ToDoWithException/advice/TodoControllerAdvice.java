package com.example.day24_Postman_ToDoWithException.advice;

import com.example.day24_Postman_ToDoWithException.exception.DuplicateIdException;
import com.example.day24_Postman_ToDoWithException.exception.IdMustExistException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

//@ControllerAdvice is a specialization of the @Component annotation which allows to handle exceptions across the whole application in one global handling component.
//It can be viewed as an interceptor of exceptions thrown by methods annotated with @RequestMapping and similar.
@ControllerAdvice
public class TodoControllerAdvice {

    //It declares @ExceptionHandler, @InitBinder, or @ModelAttribute methods to be shared across multiple @Controller classes.
    //@ExceptionHandler is an annotation for handling exceptions in specific handler classes or handler methods
    @ExceptionHandler(value = DuplicateIdException.class)
    //ResponseEntityExceptionHandler is a convenient base class for @ControllerAdvice classes that wish to provide centralized exception handling across all @RequestMapping methods through @ExceptionHandler methods.
    //It provides an methods for handling internal Spring MVC exceptions. It returns a ResponseEntity in contrast to DefaultHandlerExceptionResolver which returns a ModelAndView.
    //ResponseEntity<T> - is a builtin function
    public ResponseEntity<Map<String,Object>> handleDuplicateId(DuplicateIdException e){
        //create blank map for the message to be displayed when exception occur
        Map<String,Object> response = new HashMap<>();
        //.put(String s,Object o) -> output : Object
        response.put("message","ID already exist");
        response.put("timestamp", LocalDateTime.now());
        //badRequest() -> output : BodyBuilder
        //.body(T t) -> ResponseEntity<T>
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(value = IdMustExistException.class)
    public ResponseEntity<Map<String,Object>> handleException(IdMustExistException e){
        Map<String,Object> response = new HashMap<>();
        response.put("message","ID must exist");
        response.put("timestamp",LocalDateTime.now());
        return ResponseEntity.badRequest().body(response);
    }
}
