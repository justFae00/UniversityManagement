package UniversityManagement;

import UniversityManagement.*;
import Controllers.*;

import java.util.ArrayList;

public class User extends Data {
    public static User mainUser;

    public static ArrayList<Data> usersList = new ArrayList<>();

    public static ArrayList<Teacher> teachersList = new ArrayList<>();

    public static ArrayList<Teacher> getTeachersList() {
        return teachersList;
    }

    public static ArrayList<Subject> subjectsList = new ArrayList<>();

    public static ArrayList<Student> studentsList = new ArrayList<>();

    public static ArrayList<Student> getStudentsList() {
        return studentsList;
    }

    public static ArrayList<Term> termsList = new ArrayList<>();
}
