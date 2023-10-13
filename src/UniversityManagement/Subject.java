package UniversityManagement;

import java.util.ArrayList;
import java.util.Arrays;

public class Subject {
    public String subjectTitle;
    static ArrayList<String> syllabusList = new ArrayList<>();
    public String reference;
    public Date midtermDate;
    public Date finalDate;
    public Exam exam;

    public Subject(String title){
        subjectTitle = title;
        User.subjectsList.add(this);
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public void setSyllabus(String[] syllabuses) {
        syllabusList.addAll(Arrays.asList(syllabuses));
    }

    public String getSyllabus(){
        String result = "";
        for (String s: syllabusList){
            result += s;
            result += ", ";
        }
        return result;
    }

    public void setMidtermDate(Date midtermDate) {
        this.midtermDate = midtermDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }
}
