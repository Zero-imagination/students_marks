package dao;


import models.Mark;
import models.Student;

import java.util.List;

public interface StudentDao{
    void create(Student student);
    Student read(Integer id);
    void update(Student student);
    void delete(int id);
    List<Student> listStudent();
    /*List<Mark> studentListMark(int id);*/
}
