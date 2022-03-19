package evaluation.model;

public class Subject implements Comparable<Subject>{
    private int id;
    private String subjectName;

    //region get set methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
    //endregion


    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Subject subject) {
        return subjectName.compareTo(subject.getSubjectName());
    }
}
