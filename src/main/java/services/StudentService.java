package services;

import models.Student;

import java.util.List;

public interface StudentService {
    public void createStudent(Student student);
    public Student readStudent(int id);
    public void updateStudent(Student student);
    public void deleteStudent(int id);
    public List<Student> listStudents();
}
