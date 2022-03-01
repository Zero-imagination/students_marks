package services;

import dao.StudentDao;
import models.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService{
    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void createStudent(Student student) {
        this.studentDao.create(student);
    }

    @Override
    public Student readStudent(int id) {
        return this.studentDao.read(id);
    }

    @Override
    public void updateStudent(Student student) {
        this.studentDao.update(student);
    }

    @Override
    public void deleteStudent(int id) {
        this.studentDao.delete(id);
    }

    @Override
    public List<Student> listStudents() {
        return this.studentDao.listStudent();
    }
}
