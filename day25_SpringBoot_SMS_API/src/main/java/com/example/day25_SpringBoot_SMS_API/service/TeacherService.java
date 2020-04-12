package com.example.day25_SpringBoot_SMS_API.service;

import com.example.day25_SpringBoot_SMS_API.domain.Student;
import com.example.day25_SpringBoot_SMS_API.domain.Teacher;
import com.example.day25_SpringBoot_SMS_API.repository.StudentRepository;
import com.example.day25_SpringBoot_SMS_API.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    private TeacherRepository teacherRepository;
    //adding StudentRepository for addStudentToTeacher
    private StudentRepository studentRepository;
    @Autowired
    public TeacherService(TeacherRepository teacherRepository,StudentRepository studentRepository){
        this.teacherRepository = teacherRepository;
        //adding StudentRepository for addStudentToTeacher
        this.studentRepository = studentRepository;
    }


    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public Teacher viewTeacher(Long id) {
        //.findById(Long id) -> output : Optional<Student>
        //.orElse(Student other) -> output : Student
        return teacherRepository.findById(id).orElse(null);
    }

    public Teacher editTeacher(Long id, Teacher teacher){
        teacherRepository.findById(id)
                .map(teacher1 -> {
                    teacher1.setFirstName(teacher.getFirstName());
                    teacher1.setLastName(teacher.getLastName());
                    //save to teacherRepository
                    return teacherRepository.save(teacher1);
                });
        return null;
    }

    public void deleteTeacher(Long id){
        teacherRepository.deleteById(id);
    }

    //add student to teacher
    public Student addStudentToTeacher(Long teacherId, Long studentId){
        //create Student object -> will hold student to be added
        //.findById(Long id) -> output : Optional<Student>
        Student student = studentRepository.findById(studentId).orElse(null);
        teacherRepository.findById(teacherId).map(teacher -> {
            teacher.getStudents().add(student);
            return teacherRepository.save(teacher).getStudents();
        });
        return  null;
    }
}
