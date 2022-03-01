package models;

import java.util.Date;

public class Student {
    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private Date dateStartLearning;
    private Date dateEndLearning;

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

    public Date getDateStartLearning() {
        return dateStartLearning;
    }

    public void setDateStartLearning(Date dateStartLearning) {
        this.dateStartLearning = dateStartLearning;
    }

    public Date getDateEndLearning() {
        return dateEndLearning;
    }

    public void setDateEndLearning(Date dateEndLearning) {
        this.dateEndLearning = dateEndLearning;
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
                '}';
    }
}
