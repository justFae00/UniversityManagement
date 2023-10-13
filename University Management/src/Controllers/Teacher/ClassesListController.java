package Controllers.Teacher;

import UniversityManagement.Student;
import UniversityManagement.Term_Subject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static UniversityManagement.Department.TTSlist;
import static UniversityManagement.User.mainUser;

public class ClassesListController implements Initializable {

    @FXML
    private TextArea ViewClassesField;

    @FXML
    private Button backButton;

    @FXML
    void backButtonOnClick(ActionEvent event) throws IOException {
        switchToTchrDash(event);
    }


    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToTchrDash(javafx.event.ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/Controllers/Teacher/TeacherDashboard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 1;
        for (Term_Subject t : TTSlist) {
            if (Objects.equals(t.teacher.name, mainUser.name) & Objects.equals(t.teacher.lastname, mainUser.lastname)) {
                stringBuilder.append(i + ". " + t.subject.subjectTitle + "\t\t" + t.subject.midtermDate.printDate() +
                        "\t\t" + t.subject.finalDate.printDate() + "\t\t" +
                        t.term.gradeRegistration.printDate() + "\t\t" + t.term.termTitle + "\n");
                i++;
            }
        }
        ViewClassesField.setText(String.valueOf(stringBuilder));
    }
}
