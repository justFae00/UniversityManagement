package UniversityManagement;

import java.util.ArrayList;
import java.util.Arrays;

public class Teacher extends User {
    public ArrayList<String> teacherFields = new ArrayList<>();

    static ArrayList<Exam> examsList = new ArrayList<>();

    public Teacher(){}

    public Teacher(String tempUsername, String tempPassword, String tempName, String tempLastname){
        this.username = tempUsername;
        this.password = tempPassword;
        this.name = tempName;
        this.lastname = tempLastname;
        teachersList.add(this);
    }

    public Teacher(String tempName, String tempLastname){
        this.name = tempName;
        this.lastname = tempLastname;
    }

    public void setFields(String[] fields) {
        teacherFields.addAll(Arrays.asList(fields));
    }

    public String getFields(){
        String result = "";
        for (String s: teacherFields){
            result += s;
            result += ", ";
        }
        return result;
    }

    public void addExam(Exam exam){
        examsList.add(exam);
    }
}
