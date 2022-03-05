package models;

public class Mark {
    private int id;
    private int studentId;
    private double currentMark;
    private Subject subject;

    //region get set methods


    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public double getCurrentMark() {
        return currentMark;
    }

    public void setCurrentMark(double currentMark) {
        this.currentMark = currentMark;
    }

    //endregion

    @Override
    public String toString() {
        return "Mark{" +
                "subject=" + subject.getSubjectName() +
                ", currentMark='" + currentMark + '\'' +
                '}';
    }
}
