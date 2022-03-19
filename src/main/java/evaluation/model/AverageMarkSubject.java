package evaluation.model;

import java.util.LinkedList;
import java.util.List;

public class AverageMarkSubject implements Comparable<AverageMarkSubject>{
    private Subject subject;
    private final List<Mark> subjectMark = new LinkedList<>();

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<Mark> getSubjectMark() {
        return subjectMark;
    }


    public double averageMark(){
        double sumMark = 0;
        for (Mark mark : subjectMark) sumMark += mark.getCurrentMark();
        return sumMark/subjectMark.size();
    }


    @Override
    public int compareTo(AverageMarkSubject o) {
        return subject.compareTo(o.getSubject());
    }
}
