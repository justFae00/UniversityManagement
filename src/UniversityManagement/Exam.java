package UniversityManagement;

import java.util.ArrayList;

public class Exam {
    public String examTitle;
    public ArrayList<Problem> problemList = new ArrayList<>();

    public Exam(String title){
        examTitle = title;
    }

    public void setProblems(ArrayList<Problem> problems){
        problemList = problems;
    }
}
