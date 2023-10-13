package UniversityManagement;

public class Term_Subject extends User{
    public Term term;
    public Subject subject;
    public Teacher teacher;

    public Term_Subject(Teacher teacher, Term term, Subject subject){
        this.teacher = teacher;
        this.term = term;
        this.subject = subject;
    }

    public Subject getSubject() {
        return subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }
}
