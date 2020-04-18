package com.company.Comparable_Sort_Comparator;

//need to implements Comparable<Student>
public class Student implements Comparable<Student> {
    private long id;
    private String name;
    private long grade;

    //hover on the class then select implement methods
    @Override
    public int compareTo(Student student) {
        return (int) (this.getGrade()-student.getGrade());
    }

    public Student(){}

    public Student(long id, String name, long grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getGrade() {
        return grade;
    }

    public void setGrade(long grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
