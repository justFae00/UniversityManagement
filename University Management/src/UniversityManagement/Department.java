package UniversityManagement;

import java.io.*;
import java.util.ArrayList;

public class Department extends User {

    //singleton
    private static Department single_instance = null;

    public static Department getInstance() {
        if (single_instance == null)
            single_instance = new Department();
        single_instance.username = "admin";
        single_instance.password = "admin";

        return single_instance;
    }


    //"teacher term subject" list
    public static ArrayList<Term_Subject> TTSlist = new ArrayList<>();

    public static ArrayList<Term_Subject> getTTSlist() {
        return TTSlist;
    }

    public void addTTS(Teacher teacher, Term term, Subject subject) throws IOException {
        Term_Subject TTS = new Term_Subject(teacher, term, subject);
        TTSlist.add(TTS);

        try(FileWriter fw = new FileWriter("DataBase.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)) {
            out.println(TTS.subject.subjectTitle + "#" + TTS.term.termTitle + "@" + TTS.teacher.name + " " + TTS.teacher.lastname + "$");
            System.out.println("DONE");

        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }


    //subject-exam list
    public static ArrayList<Subject_Exam> SElist = new ArrayList<>();

    //calling constructors
    public void addTeacher(String tempUsername, String tempPassword, String tempName, String tempLastname){
        Teacher teacher = new Teacher(tempUsername, tempPassword, tempName, tempLastname);
        usersList.add(teacher);
    }

    public void addTerm(String title, Date gradeReg, Date termB, Date termE){
        Term term = new Term(title, gradeReg, termB, termE);
    }

    public void addStudent(String tempUsername, String tempPassword, String tempName, String tempLastname, int tempStdNo){
        Student student = new Student(tempUsername, tempPassword, tempName, tempLastname, tempStdNo);
        usersList.add(student);
    }
}