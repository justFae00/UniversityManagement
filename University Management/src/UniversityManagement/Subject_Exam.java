package UniversityManagement;

import java.util.ArrayList;

public class Subject_Exam {
    public Subject subject;
    public ArrayList<Exam> examsList = new ArrayList<>();

    public Subject_Exam(Subject subject){
        this.subject = subject;
    }

    public void addExam(Exam exam){
        examsList.add(exam);
    }
}
