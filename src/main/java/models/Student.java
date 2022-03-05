package models;

import java.util.Date;
import java.util.HashSet;
import java.time.LocalDate;
import java.util.Set;

public class Student {
    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate dateStartLearning;
    private LocalDate dateEndLearning;
    private Set<Mark> allMarks = new HashSet<>(0);


    //region get set methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getDateStartLearning() {
        return dateStartLearning;
    }

    public void setDateStartLearning(LocalDate dateStartLearning) {
        this.dateStartLearning = dateStartLearning;
    }

    public LocalDate getDateEndLearning() {
        return dateEndLearning;
    }

    public void setDateEndLearning(LocalDate dateEndLearning) {
        this.dateEndLearning = dateEndLearning;
    }

    public Set<Mark> getAllMarks() {
        return allMarks;
    }

    public void setAllMarks(Set<Mark> allMarks) {
        this.allMarks = allMarks;
    }

    //endregion


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dateStartLearning=" + dateStartLearning +
                ", dateEndLearning=" + dateEndLearning +
                ", marks=" + allMarks +
                '}';
    }
    public String onlyFullName()
    {
        return "Student "+ name +" "+ surname +" "+ patronymic;
    }
}
