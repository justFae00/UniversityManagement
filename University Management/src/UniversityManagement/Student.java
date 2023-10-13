package UniversityManagement;

import javafx.collections.ObservableArray;

import java.util.ArrayList;
import java.util.Objects;

public class Student extends User {
    public int stdNo;

    public Student(String tempUsername, String tempPassword, String tempName, String tempLastname, int tempStdNo){
        this.username = tempUsername;
        this.password = tempPassword;
        this.name = tempName;
        this.lastname = tempLastname;
        this.stdNo = tempStdNo;
        studentsList.add(this);
    }

    public Student(){}

    //list of subjects the student is attending
    public static ArrayList<Subject> stdSubjectsList = new ArrayList<>();

    public static ArrayList<Term_Subject> studentTTS = new ArrayList<>();
}
