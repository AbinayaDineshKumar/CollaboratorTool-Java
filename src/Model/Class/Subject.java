package Model.Class;
public class Subject {
    private int subjectId;
    private String subjectName;
    
    // Constructor
    public Subject(int subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }
    
    // Getters
    public int getSubjectId() {
        return subjectId;
    }
    
    public String getSubjectName() {
        return subjectName;
    }
    
    // Setters
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }
    
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
