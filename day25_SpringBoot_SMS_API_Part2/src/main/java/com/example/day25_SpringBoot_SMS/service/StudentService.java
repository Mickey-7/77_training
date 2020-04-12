package com.example.day25_SpringBoot_SMS.service;

import com.example.day25_SpringBoot_SMS.domain.Student;
import com.example.day25_SpringBoot_SMS.domain.Teacher;
import com.example.day25_SpringBoot_SMS.repository.StudentRepository;
import com.example.day25_SpringBoot_SMS.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    //added for getTeacherByStudentName
    private TeacherRepository teacherRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository,TeacherRepository teacherRepository){
        this.studentRepository = studentRepository;
        //added for getTeacherByStudentName
        this.teacherRepository = teacherRepository;
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public Student viewStudent(Long id) {
        //.findById(Long id) -> output : Optional<Student>
        //.orElse(Student other) -> output : Student
        return studentRepository.findById(id).orElse(null);
    }

    public Student editStudent(Long id, Student student){
        studentRepository.findById(id)
                .map(student1 -> {
                    student1.setFirstName(student.getFirstName());
                    student1.setLastName(student.getLastName());
                    student1.setGrade(student.getGrade());
                    //save to studentRepository
                    return studentRepository.save(student1);
                });
        return null;
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

    //Search Students By First Name And Last Name
    public Student searchStudentByFirstAndLastName(String firstName, String lastName){
        return studentRepository.findByFirstNameAndLastName(firstName,lastName);
    }

    //- Search Teachers by Student Name (contains)
    public Teacher getTeacherByStudentName(String firstName){
        //store the student then iterate on the teacherRepository to find the student
        Student student = studentRepository.findByFirstNameContaining(firstName);
        //.findAll() -> output : List<Teacher>
        for (int i = 0; i < teacherRepository.findAll().size(); i++) {
            //.get(int i) -> output : Teacher
            //.getStudents() -> output : List<Student>
            //.contains(Object o) -> output : Boolean
            if (teacherRepository.findAll().get(i).getStudents().contains(student)){
                return teacherRepository.findAll().get(i);
            }
        }
        return null;
    }
}
