package gui;

import dao.*;
import models.Mark;
import models.Student;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import services.MarkServiceImpl;
import services.StudentServiceImpl;

public class App {
    public static void main(String[] args) {
        StudentServiceImpl studentService = new StudentServiceImpl();
        MarkServiceImpl markService = new MarkServiceImpl();
        //Student student = studentService.readStudent(2);
        //System.out.println(student);
        List<Student> studentList = studentService.readListStudents();
        for (Student student1 : studentList){
            System.out.println(student1);
        }
        /*SessionFactory factory = null;
        try {
            *//*factory = new Configuration().configure().buildSessionFactory();

            StudentDao studentDao = new StudentDaoImpl(factory);
            MarkDao markDao = new MarkDaoImpl(factory);*//*

            //update(studentDao);
            //create(studentDao);
            //createMark(studentDao, markDao);

            //delete(studentDao);

            //deleteMark(markDao);

            //readAllStudents(studentDao);
            //readStudent(studentDao);
            //readStudentMarks(studentDao);

            //readMark(markDao);


        } finally {
            if (factory != null) {
                factory.close();
            }
        }*/
    }
    private static void delete(StudentDao studentDao) {

        studentDao.delete(9);
        System.out.println("Deleted");
    }
    private static void deleteMark(MarkDao markDao){
        markDao.delete(13);
        System.out.println("Deleted");
    }
    private static void readStudent(StudentDao studentDao){
        Student student = studentDao.read(2);
        System.out.println("Read: "+student);
    }
    private static void readStudentMarks(StudentDao studentDao){
        Student student= studentDao.read(1);
        Set<Mark> marks = student.getAllMarks();
        System.out.println("Read: "+student.onlyFullName());
        for (Mark mark : marks){
            System.out.println(mark);
        }
    }

    private static void readMark(MarkDao markDao){
        System.out.println(markDao.read(3));
    }
    private static void create(StudentDao studentDao) {
        Student student = new Student();
        student.setName("Василий");
        student.setSurname("Волков");
        student.setPatronymic("Артемович");
        student.setDateStartLearning(LocalDate.of(2015, 9, 30));
        student.setDateEndLearning(LocalDate.of(2019, 9, 30));
        studentDao.create(student);
        System.out.println("Created");
    }
    private static void createMark(StudentDao studentDao, MarkDao markDao){
        Mark mark = new Mark();
        mark.setCurrentMark(1.0);
        Student student = studentDao.read(10);
        mark.setStudentId(student.getId());
        markDao.create(mark);
        System.out.println("Created: " + studentDao.read(10));
    }


    public static void readAllStudents(StudentDao studentDao) {
            List<Student> studentList = studentDao.listStudent();
            for (Student student : studentList) {
                System.out.println(student);
            }
    }
}
