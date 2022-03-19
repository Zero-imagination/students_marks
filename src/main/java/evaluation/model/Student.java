package evaluation.model;

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
        for (Mark mark : allMarks){
            boolean markAdded = false;
            for (AverageMarkSubject average : averageMarkSubjects){
                if (average.getSubject()==mark.getSubject()){
                    average.getSubjectMark().add(mark);
                    markAdded = true;
                    break;
                }
            }
            if (!markAdded){
                AverageMarkSubject currentAverageMarkSubject = new AverageMarkSubject();
                currentAverageMarkSubject.setSubject(mark.getSubject());
                currentAverageMarkSubject.getSubjectMark().add(mark);
                averageMarkSubjects.add(currentAverageMarkSubject);
            }
        }
        Collections.sort(averageMarkSubjects);
        return averageMarkSubjects;
    }
    public AverageMarkSubject getAverageMarkSubject(String subjectName){
        for (AverageMarkSubject currentAverageMarkSubject : getAverageMarkSubjects()){
            if (Objects.equals(subjectName, currentAverageMarkSubject.getSubject().getSubjectName())){
                Collections.sort(currentAverageMarkSubject.getSubjectMark());
                return currentAverageMarkSubject;
            }
        }
        return null;
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
