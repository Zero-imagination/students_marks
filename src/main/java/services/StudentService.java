package services;

import models.Student;

import java.util.List;

public interface StudentService {
    void createStudent(Student student);
    Student readStudent(int id);
    void updateStudent(Student student);
    void deleteStudent(int id);
    List<Student>readListStudents();
}
