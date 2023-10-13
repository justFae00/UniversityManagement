package Controllers.Teacher;

import UniversityManagement.*;
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
import java.util.ResourceBundle;

public class ViewStdofClassController implements Initializable {

    @FXML
    private TextArea ViewStudentsField;

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
        int j = 1;
        for (Term_Subject t : Department.TTSlist) {
            if (t.teacher == User.mainUser) {
                stringBuilder.append(i + ". " + t.subject.subjectTitle + ":\n");
                i++;
                for (Student s : User.studentsList) {
                    for (Subject su : s.stdSubjectsList) {
                        if (su == t.subject) {
                            stringBuilder.append("\t\t" + j + ". " + s.name + " " + s.lastname + "\t\t" + s.stdNo + "\n");
                            j++;
                        }
                    }
                }
            }
        }
        ViewStudentsField.setText(String.valueOf(stringBuilder));
    }
}
