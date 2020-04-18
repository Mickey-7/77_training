package com.company.Exercise;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static File file = new File("C:\\Users\\donat\\Documents\\to_be_done\\seven_seven_trainings\\day5_FileWriterReader_SMS\\src\\com\\company\\CreatedFiles\\PseudoDB.enc");
    private static School school = new School();
    private static List<Teacher> teachers = new ArrayList<>();


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //File Writing/Reading & New Date:
        //Class:
            //School - name, list of teachers
            //Teacher - id, name, list of students, createDateTime, updateDateTime
            //Student - id, name, grade createDateTime, updateDateTime
        //Main(UI):
            //Note: at the start of the program, read object file (pseudo-db)
            //Note: changes should update the object file (pseudo-db)
            //Add Teacher
                //Add Student
            //Get All Teacher
            //Get All Students (whole school)
            //Get All Student by Teacher
            //Update Student by ID
            //Transfer Student to another Teacher (By Student ID & Teacher ID)
            //Remove Student
            //Get Top N Students (school-wide)

        //Note: at the start of the program, read object file (pseudo-db)
        checkIfPseudoDBExist();

        System.out.println("enter school name: ");
        String schoolName = scanner.next();
        school.setName(schoolName);
        System.out.println("welcome to "+schoolName+" university");

        System.out.println("what would you like to do?\n" +
                "1) Add Teacher\n" +
                "2) Get All Teachers\n" +
                "3) Get All Students\n" +
                "4) Get All Student by Teacher\n" +
                "5) Update Student by ID\n" +
                "6) Transfer Student to another Teacher\n" +
                "7) Remove Student\n" +
                "8) Get Top N Students\n" +
                "9) Exit");
        int toDo = scanner.nextInt();

        boolean status = true;
        while (status){
            while (toDo==1){
                System.out.println("case1");
                System.out.println(addTeacher());

                System.out.println("what would you like to do?\n" +
                        "1) Add Teacher\n" +
                        "2) Get All Teachers\n" +
                        "3) Get All Students\n" +
                        "4) Get All Student by Teacher\n" +
                        "5) Update Student by ID\n" +
                        "6) Transfer Student to another Teacher\n" +
                        "7) Remove Student\n" +
                        "8) Get Top N Students\n" +
                        "9) Exit");
                toDo = scanner.nextInt();

            }
            while (toDo==2){
                System.out.println("case2");
                System.out.println(getAllTeachers());

                System.out.println("what would you like to do?\n" +
                        "1) Add Teacher\n" +
                        "2) Get All Teachers\n" +
                        "3) Get All Students\n" +
                        "4) Get All Student by Teacher\n" +
                        "5) Update Student by ID\n" +
                        "6) Transfer Student to another Teacher\n" +
                        "7) Remove Student\n" +
                        "8) Get Top N Students\n" +
                        "9) Exit");
                toDo = scanner.nextInt();

            }
            while (toDo==3){
                System.out.println("case3");
//                System.out.println(getAllStudents());
                //i have no fucking idea why the method won't work

                for(Teacher teacher : teachers){
                    System.out.println(teacher.getStudents());
                }

                System.out.println("what would you like to do?\n" +
                        "1) Add Teacher\n" +
                        "2) Get All Teachers\n" +
                        "3) Get All Students\n" +
                        "4) Get All Student by Teacher\n" +
                        "5) Update Student by ID\n" +
                        "6) Transfer Student to another Teacher\n" +
                        "7) Remove Student\n" +
                        "8) Get Top N Students\n" +
                        "9) Exit");
                toDo = scanner.nextInt();

            }
            while (toDo==4){
                System.out.println("case4");
                System.out.println("enter teacher id: ");
                long id = scanner.nextLong();
                System.out.println(getAllStudentsByTeacher(id));

                System.out.println("what would you like to do?\n" +
                        "1) Add Teacher\n" +
                        "2) Get All Teachers\n" +
                        "3) Get All Students\n" +
                        "4) Get All Student by Teacher\n" +
                        "5) Update Student by ID\n" +
                        "6) Transfer Student to another Teacher\n" +
                        "7) Remove Student\n" +
                        "8) Get Top N Students\n" +
                        "9) Exit");
                toDo = scanner.nextInt();

            }
            while (toDo==5){
                System.out.println("case5");

                System.out.println("enter student id: ");
                long id = scanner.nextLong();
                System.out.println("enter student new grade: ");
                double grade = scanner.nextDouble();

                updateStudentByID(id,grade);

                System.out.println("done updating");

                System.out.println("what would you like to do?\n" +
                        "1) Add Teacher\n" +
                        "2) Get All Teachers\n" +
                        "3) Get All Students\n" +
                        "4) Get All Student by Teacher\n" +
                        "5) Update Student by ID\n" +
                        "6) Transfer Student to another Teacher\n" +
                        "7) Remove Student\n" +
                        "8) Get Top N Students\n" +
                        "9) Exit");
                toDo = scanner.nextInt();

            }
            while (toDo==6){
                System.out.println("case6");

                System.out.println("enter teacher id: ");
                long teacherID = scanner.nextLong();
                System.out.println("enter student id: ");
                long studentID = scanner.nextLong();
                System.out.println("enter new teacher id: ");
                long newTeacherID = scanner.nextLong();

                transferStudent(teacherID,studentID,newTeacherID);

                System.out.println("done transferring");

                System.out.println("what would you like to do?\n" +
                        "1) Add Teacher\n" +
                        "2) Get All Teachers\n" +
                        "3) Get All Students\n" +
                        "4) Get All Student by Teacher\n" +
                        "5) Update Student by ID\n" +
                        "6) Transfer Student to another Teacher\n" +
                        "7) Remove Student\n" +
                        "8) Get Top N Students\n" +
                        "9) Exit");
                toDo = scanner.nextInt();

            }
            while (toDo==7){
                System.out.println("case7");

                System.out.println("enter student id: ");
                long id = scanner.nextLong();

                removeStudent(id);

                System.out.println("done removing");

                System.out.println("what would you like to do?\n" +
                        "1) Add Teacher\n" +
                        "2) Get All Teachers\n" +
                        "3) Get All Students\n" +
                        "4) Get All Student by Teacher\n" +
                        "5) Update Student by ID\n" +
                        "6) Transfer Student to another Teacher\n" +
                        "7) Remove Student\n" +
                        "8) Get Top N Students\n" +
                        "9) Exit");
                toDo = scanner.nextInt();

            }
            while (toDo==8){
                System.out.println("case8");

                System.out.println("enter N value");
                int x = scanner.nextInt();

                getTopNStudents(x);

                System.out.println("done displaying");

                System.out.println("what would you like to do?\n" +
                        "1) Add Teacher\n" +
                        "2) Get All Teachers\n" +
                        "3) Get All Students\n" +
                        "4) Get All Student by Teacher\n" +
                        "5) Update Student by ID\n" +
                        "6) Transfer Student to another Teacher\n" +
                        "7) Remove Student\n" +
                        "8) Get Top N Students\n" +
                        "9) Exit");
                toDo = scanner.nextInt();

            }
            while (toDo==9){
                System.out.println("exiting program......!");
                status=false;
                break;
            }

        }
    }

    public static void checkIfPseudoDBExist() throws IOException {
        System.out.println("checking PseudoDB existence......!");
        //check if PseudoDB exist
        if (!file.exists()){
            file.createNewFile();
            System.out.println("PseudoDB created......!");
        }
    }

    public static void writeToPseudoDBUsingOOS(Object schoolName) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(schoolName);
        fos.close();
        oos.close();
        System.out.println("done writing schoolName to pseudoDB......!");
    }

    public static Object readFromPseudoDBUsingIOS() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object schoolName = ois.readObject();
        System.out.println("done reading schoolName from pseudoDB......!");
        return schoolName;
    }

    //Add Teacher
        //Add Student
    public static School addTeacher() throws IOException, ClassNotFoundException {
        //need to create a blank students arrayList here so that it will not be distributed on all teacher and will be applicable only to this loop
        List<Student> students = new ArrayList<>();
        Teacher teacher = new Teacher();
        System.out.println("enter teacher id: ");
        long teacherID = scanner.nextLong();
        teacher.setId(teacherID);
        System.out.println("enter teacher name: ");
        String teacherName = scanner.next();
        teacher.setName(teacherName);
        teacher.setCreateDateTime(LocalDateTime.now());
        System.out.println("do you want to add students?\n" +
                "1) Yes\n" +
                "2) No");
        int addStudent = scanner.nextInt();
        if (addStudent==1){
            System.out.println("how many students you want to add: ");
            int studCount = scanner.nextInt();
            for (int i = 0; i < studCount; i++) {
                Student student = new Student();
                System.out.println("enter student id: ");
                long studId = scanner.nextLong();
                student.setId(studId);
                System.out.println("enter student name: ");
                String studName = scanner.next();
                student.setName(studName);
                System.out.println("enter student grade: ");
                double studGrade = scanner.nextDouble();
                student.setGrade(studGrade);
                student.setCreateDateTime(LocalDateTime.now());
                students.add(student);
            }
            teacher.setStudents(students);
            teachers.add(teacher);
            school.setTeachers(teachers);
            writeToPseudoDBUsingOOS(school);
            return (School) readFromPseudoDBUsingIOS();

        }else if(addStudent==2){
            System.out.println("Okay");

        }else {
            System.out.println("invalid option");
        }

        return null;
    }

    //Get All Teacher
    private static List<Teacher> getAllTeachers(){
         return school.getTeachers();
    }

    //Get All Students (whole school) - only outputs student of first teacher - no iteration going on
    private static List<Student> getAllStudents(){
        for (int i = 0; i < teachers.size(); i++) {
            return teachers.get(i).getStudents();
        }
        return null;
    }

    //Get All Student by Teacher
    private static List<Student> getAllStudentsByTeacher(Long id){
        for(Teacher teacher: teachers){
            if(teacher.getId().equals(id)){
                return teacher.getStudents();
            }
        }
        return null;
    }

    //Update Student by ID
    private static Student updateStudentByID(Long id, Double grade ){
        //i range - applicable to all teachers arrayList
        for (int i = 0; i < school.getTeachers().size(); i++) {
            //j range - applicable to all students arrayList
            for (int j = 0; j < school.getTeachers().get(i).getStudents().size(); j++) {
                //powerful use of .get(int i) method - for finding iteration on arrayList
                if (school.getTeachers().get(i).getStudents().get(j).getId().equals(id)){
                    school.getTeachers().get(i).getStudents().get(j).setGrade(grade);
                    school.getTeachers().get(i).getStudents().get(j).setUpdateDateTime(LocalDateTime.now());
                    return school.getTeachers().get(i).getStudents().get(j);
                }
            }
        }
        return null;
    }

    //Transfer Student to another Teacher (By Student ID & Teacher ID)
    public static void transferStudent(Long teacherID,Long studentID, Long newTeacherID){
        Student student = new Student();

        //i range - applicable to all teachers arrayList
        for (int i = 0; i < school.getTeachers().size(); i++) {
            //powerful use of .get(int i) method - for finding iteration on arrayList
            if (school.getTeachers().get(i).getId().equals(teacherID)){
                //j range - applicable to all students arrayList
                for (int j = 0; j < school.getTeachers().get(i).getStudents().size(); j++) {
                    //powerful use of .get(int i) method - for finding iteration on arrayList
                    if (school.getTeachers().get(i).getStudents().get(j).getId().equals(studentID)){
                        //storing the student to be transferred
                        student = school.getTeachers().get(i).getStudents().get(j);
                        //removing the student to be transferred
                        school.getTeachers().get(i).getStudents().remove(j);
                    }
                }
            }
        }

        //i range - applicable to all teachers arrayList
        for (int i = 0; i < school.getTeachers().size(); i++) {
            //powerful use of .get(int i) method - for finding iteration on arrayList
            if (school.getTeachers().get(i).getId().equals(newTeacherID)){
                //the .getStudents(List<Student>) method contains .add(Student) method
                student.setUpdateDateTime(LocalDateTime.now());
                school.getTeachers().get(i).getStudents().add(student);

            }
        }
    }

    //Remove Student
    public static void removeStudent(Long id){
        //i range - applicable to all teachers arrayList
        for (int i = 0; i < school.getTeachers().size(); i++) {
            //j range - applicable to all students arrayList
            for (int j = 0; j < school.getTeachers().get(i).getStudents().size(); j++) {
                if (school.getTeachers().get(i).getStudents().get(j).getId().equals(id)){
                    school.getTeachers().get(i).getStudents().remove(j);    //remove j not id
                }
            }
        }
    }

    //Get Top N Students (school-wide)
    public static void getTopNStudents(int x) {
        //create blank arrayList of top N students
        List<Student> studentList = new ArrayList<>();

        //i range - applicable to all teachers arrayList
        for (int i = 0; i < school.getTeachers().size(); i++) {
            //j range - applicable to all students arrayList
            for (int j = 0; j < school.getTeachers().get(i).getStudents().size(); j++) {
                //getting all student .get(j) and storing it on arrayList
                studentList.add(school.getTeachers().get(i).getStudents().get(j));
            }
        }
        //sorting from low-high
        studentList.sort((student, t1) -> {
            return (int) (t1.getGrade()-student.getGrade());
        });
        System.out.println(studentList);
//        System.out.println(studentList.size());//total number of students

//        while (x>0){
//            System.out.println("top"+x+" : "+studentList.get(studentList.size()-x));
//            x--;
//            //n-x - lowest
//            //n-(x-1) - middle
//            //n-(x-2) - highest

            //trying another solution - using subList

            System.out.println("top "+x+" students: "+studentList.subList(0,x));








//        for (Teacher teacher : teachers){
//            //sorted from highest - lowest
//            teacher.getStudents().sort((student, t1) -> (int) (t1.getGrade()-student.getGrade()));
//
////                System.out.println( teacher.getStudents().get(x-1));  //outputs specific nth top value
////                //need to put -1 on the .get(x) method to avoid error below: IndexOutOfBoundsException
////                //what would you like to do?
////                //1) Add Teacher
////                //2) Get All Teachers
////                //3) Get All Students
////                //4) Get All Student by Teacher
////                //5) Update Student by ID
////                //6) Transfer Student to another Teacher
////                //7) Remove Student
////                //8) Get Top N Students
////                //9) Exit
////                //8
////                //case8
////                //enter N value
////                //3
////                //Exception in thread "main" java.lang.IndexOutOfBoundsException: Index 3 out of bounds for length 3
////                //	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
////                //	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
////                //	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
////                //	at java.base/java.util.Objects.checkIndex(Objects.java:372)
////                //	at java.base/java.util.ArrayList.get(ArrayList.java:458)
////                //	at com.company.Exercise.Main.getTopNStudents(Main.java:400)
////                //	at com.company.Exercise.Main.main(Main.java:211)
//
//            System.out.println(teacher.getStudents());
//            //enhanced forLoop is not applicable to all teachers as it wont display correct output -  see below:
//            //what would you like to do?
//            //1) Add Teacher
//            //2) Get All Teachers
//            //3) Get All Students
//            //4) Get All Student by Teacher
//            //5) Update Student by ID
//            //6) Transfer Student to another Teacher
//            //7) Remove Student
//            //8) Get Top N Students
//            //9) Exit
//            //8
//            //case8
//            //enter N value
//            //1
//            //[Student{id=1, name='s1', grade=12.0, createDateTime=2020-03-23T17:49:17.577517400, updateDateTime=null}]
//            //[Student{id=2, name='s2', grade=23.0, createDateTime=2020-03-23T17:49:33.551215700, updateDateTime=null}]
//            //[Student{id=2, name='s4', grade=65.0, createDateTime=2020-03-23T17:51:08.077695300, updateDateTime=null}, Student{id=1, name='s1', grade=34.0, createDateTime=2020-03-23T17:51:02.054039900, updateDateTime=null}]



    }

}
