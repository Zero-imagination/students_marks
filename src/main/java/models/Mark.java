package models;

public class Mark {
    private int id;
    private Student student;
    private String currentMark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getCurrentMark() {
        return currentMark;
    }

    public void setCurrentMark(String currentMark) {
        this.currentMark = currentMark;
    }


}
