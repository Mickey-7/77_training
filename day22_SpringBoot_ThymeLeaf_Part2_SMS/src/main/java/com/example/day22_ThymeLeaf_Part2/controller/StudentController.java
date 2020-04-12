package com.example.day22_ThymeLeaf_Part2.controller;

import com.example.day22_ThymeLeaf_Part2.domain.Student;
import com.example.day22_ThymeLeaf_Part2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    //create api controller for home.html
    @GetMapping("home")             //pertains to the url web browser
    public String home(Model model){
        System.out.println("This is Home API Controller");
        //creating a text message to be displayed on home page
        //.addAttribute(String s,Object o) -> output : Model
        model.addAttribute("message","Welcome Home");
        return "home";              //pertains to the home.html
    }

    //create controller for addStudent.html
    //create first ModelMap which will contain our new created student
    @GetMapping("addGet")                 //pertains to the url web browser
    public String addStudent(ModelMap modelMap){
        System.out.println("This is addStudent Get Controller");
        //creating ans storing the student fields
        //.addAttribute(String attributeName, Object attributeObject) -> output : ModelMap
        modelMap.addAttribute("student", new Student());
        return "addStudent";            //pertains to .html file
    }
    //create the post method for addStudent
    @PostMapping("addPost")     //pertains to the url web browser - quick lng then will be redirected to viewAllStudents
    public String addStudent(Student student){
        System.out.println("This is addStudent Post Controller");
        studentService.addStudent(student);
        //redirecting to viewAllStudents
        return "redirect:/getAllStudents";       //pertains to the url web browser
    }

    //create  controller for getAllStudents
    //need to create ModelMap for list of students
    @GetMapping("getAllStudents")                    //pertains to the url web browser
    public String getAllStudents(ModelMap modelMap){
        System.out.println("This is viewAllStudents Controller");
        modelMap.addAttribute("students",studentService.getAllStudents());
        return "viewAllStudents";                               //pertains to .html file
    }

    //create  controller for updateStudent
    //create first ModelMap for student to be updated
    @GetMapping("updateStudentGet/{id}")                     //pertains to the url web browser - manually put the id
    public String updateStudent(@PathVariable Long id,ModelMap modelMap){
        //create a blank Student object which will contain the student id to be updated
        Student oldStudent = studentService.getStudentId(id);
        //modelMap to set the oldStudent to be updated to display on ui
        modelMap.addAttribute("student",oldStudent);
        System.out.println("This is updateStudent Get Controller");
        return "updateStudent";                          //pertains to .html file
    }
    //create  controller for post updateStudent
    @PostMapping("updateStudentPost/{id}")                    //pertains to the url web browser
    public String updateStudent(@PathVariable Long id,Student student){
        System.out.println("This is updateStudent Post Controller");
        studentService.updateStudent(id,student);
        //redirecting to viewAllStudents
        return "redirect:/getAllStudents";                //pertains to the url web browser
    }

    //create  controller for deleteStudent
    //create a ModelMap for the student to be deleted
    @GetMapping("deleteStudent/{id}")                     //pertains to the url web browser - manually put the id
    public String deleteStudent(@PathVariable Long id,ModelMap modelMap){
        //create blank student which will contain student to be deleted
        Student oldStudent = studentService.getStudentId(id);
        //modelMap to set the student to be deleted to display on ui
        modelMap.addAttribute("student",oldStudent);
        System.out.println("This is deleteController Get Controller");
        return "delete";                            //pertains to .html file
    }
    //create  controller for post deleteStudent
    @PostMapping("deleteStudentPost/{id}")                    //pertains to the url web browser
    public String deleteStudent(@PathVariable Long id){
        //create blank student which will contain student to be deleted
        Student oldStudent = studentService.getStudentId(id);
        //invoking studentService
        studentService.deleteStudent(id);
        System.out.println("This is deleteController Post Controller");
        //redirecting to viewAllStudents
        return "redirect:/getAllStudents";                //pertains to the url web browser
    }


}
