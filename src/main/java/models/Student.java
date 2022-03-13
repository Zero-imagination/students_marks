package models;

import java.util.*;
import java.time.LocalDate;

public class Student {
    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate dateStartLearning;
    private LocalDate dateEndLearning;
    private Set<Mark> allMarks = new LinkedHashSet<>(0);


    public List<AverageMarkSubject> getAverageMarkSubjects() {
        List<AverageMarkSubject> averageMarkSubjects = new LinkedList<>();
        TreeSet<Subject> uniqueSubjects= new TreeSet<>();
        for (Mark mark : allMarks){
            uniqueSubjects.add(mark.getSubject());
        }
        for (Subject subject : uniqueSubjects){
            AverageMarkSubject currentAverageMarkSubject = new AverageMarkSubject();
            currentAverageMarkSubject.setSubject(subject);
            List<Mark> subjectMarks = new LinkedList<>();
            for (Mark mark : allMarks){
                if (mark.getSubject()==subject)
                    subjectMarks.add(mark);
            }
            currentAverageMarkSubject.setSubjectMark(subjectMarks);
            averageMarkSubjects.add(currentAverageMarkSubject);
        }
        return averageMarkSubjects;
    }
    public AverageMarkSubject getAverageMarkSubject(String subjectName){
        AverageMarkSubject localMarkSubject = new AverageMarkSubject();
        List<AverageMarkSubject> averageMarkSubjectList = getAverageMarkSubjects();
        for (AverageMarkSubject currentAverageMarkSubject : averageMarkSubjectList){
            if (Objects.equals(subjectName, currentAverageMarkSubject.getSubject().getSubjectName())){
                localMarkSubject.setSubject(currentAverageMarkSubject.getSubject());
                localMarkSubject.setSubjectMark(currentAverageMarkSubject.getSubjectMark());
            }
        }
        return localMarkSubject;
    }


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
