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
    private final ArrayList<String[]> subjectAvgMarks = new ArrayList<>(0);

    public ArrayList<String[]> getSubjectAvgMarks() {
        Set<Subject> subjects=new LinkedHashSet<>();
        for (Mark mark : allMarks){
            subjects.add(mark.getSubject());
        }
        double[][] supp = new double[subjects.size()][2];
        int iterator =0;
        for (Subject subject : subjects){
            for (Mark mark : allMarks){
                if (mark.getSubject()==subject){
                    supp[iterator][0] += mark.getCurrentMark();
                    supp[iterator][1]++;
                }
            }
            subjectAvgMarks.add(new String[]{subject.getSubjectName(),
                    String.format(Locale.ENGLISH,"%.2f",supp[iterator][0]/supp[iterator][1])});
            iterator++;
        }
        return subjectAvgMarks;
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
