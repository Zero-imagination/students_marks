package models;

import java.util.LinkedList;
import java.util.List;

public class AverageMarkSubject {
    private Subject subject;
    private List<Mark> subjectMark = new LinkedList<>();

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<Mark> getSubjectMark() {
        return subjectMark;
    }

    public void setSubjectMark(List<Mark> subjectMark) {
        this.subjectMark = subjectMark;
    }

    public double averageMark(){
        double sumMark = 0;
        for (Mark mark : subjectMark) sumMark += mark.getCurrentMark();
        return sumMark/subjectMark.size();
    }
}
