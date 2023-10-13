
import UniversityManagement.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Struct;
import java.time.LocalDate;

public class AppInitilizer extends Application implements EventHandler<ActionEvent>{


    public static void main(String[] args) throws IOException {

        ////
        Department department = Department.getInstance();
        Teacher teacher1 = new Teacher("teacher1", "1234" ,"Bojack", "Horseman");
        String[] s = {"math", "physic"};
        teacher1.setFields(s);
        Student student1 = new Student("student1", "1234","Faeze", "Ebrahimi", 40030498);
        Student student2 = new Student("student2", "1234","Moraba", "Paniri", 54000584);
        Subject subject1 = new Subject("math");
        Date date1 = new Date(10,5,1999);
        subject1.setMidtermDate(date1);
        subject1.setFinalDate(date1);
        Term term1 = new Term("Spring", date1, date1, date1);
        Term_Subject term_subject = new Term_Subject(teacher1, term1, subject1);
        department.TTSlist.add(term_subject);
        ////

        launch(args);
        report();
    }


    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Controllers/Main/LogIn.fxml"))));
        primaryStage.show();
    }

    @Override
    public void handle(ActionEvent event) {

    }


    //write data in separate files
    public static void report(){

        //Students
        try {
            StringBuilder stringBuilder = new StringBuilder();
            int i = 1;
            stringBuilder.append("  Name\t\tStdNumber\tUsername\tPassword\n");
            for (Student s: User.studentsList){
                stringBuilder.append(i + ". " + s.name + " " + s.lastname + "\t" + s.stdNo + "\t" + s.username +
                        "\t" + s.password + "\n");
                i++;
            }
            FileWriter myWriter = new FileWriter("StudentsData.txt");
            myWriter.write(String.valueOf(stringBuilder));
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Teachers
        try {
            StringBuilder stringBuilder = new StringBuilder();
            int i = 1;
            stringBuilder.append("  Name\t\tFields\tUsername\tPassword\n");
            for (Teacher t: User.teachersList){
                stringBuilder.append(i + ". " + t.name + " " + t.lastname + "\t" + t.getFields() + "\t" + t.username +
                        "\t" + t.password + "\n");
                i++;
            }
            FileWriter myWriter = new FileWriter("TeachersData.txt");
            myWriter.write(String.valueOf(stringBuilder));
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Subjects
        try {
            StringBuilder stringBuilder = new StringBuilder();
            int i = 1;
            stringBuilder.append("  Subject Title\tReference\tSyllabuses\tMidterm Date\tFinal Date\n");
            for (Subject s: User.subjectsList){
                stringBuilder.append(i + ". " + s.subjectTitle + "\t" + s.reference + "\t" + s.getSyllabus() +
                        "\t" + s.midtermDate.printDate() + "\t" + s.finalDate.printDate() + "\n");
                i++;
            }
            FileWriter myWriter = new FileWriter("SubjectsData.txt");
            myWriter.write(String.valueOf(stringBuilder));
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Term
        try {
            StringBuilder stringBuilder = new StringBuilder();
            int i = 1;
            stringBuilder.append("  Term Title\tGrade Registration\tStart Date\tFinal Date\n");
            for (Term t: User.termsList){
                stringBuilder.append(i + ". " + t.termTitle + "\t" + t.gradeRegistration.printDate() + "\t"
                        + t.termBeginning + "\t" + t.termEnding + "\n");
                i++;
            }
            FileWriter myWriter = new FileWriter("TermsData.txt");
            myWriter.write(String.valueOf(stringBuilder));
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}