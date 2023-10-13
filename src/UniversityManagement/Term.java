package UniversityManagement;

import static UniversityManagement.Department.TTSlist;

public class Term{
    public String termTitle;
    public Date gradeRegistration;
    public Date termBeginning;
    public Date termEnding;

    public Term(String title, Date gradeReg, Date termB, Date termE){
        this.termTitle = title;
        this.gradeRegistration = gradeReg;
        this.termBeginning = termB;
        this.termEnding = termE;

        User.termsList.add(this);
    }

    public String getSubjects(){
        String result = "";
        for (Term_Subject t: TTSlist){
            if (t.term == this){
                result += t.subject.subjectTitle;
                result += ", ";
            }
        }return result;
    }
}
