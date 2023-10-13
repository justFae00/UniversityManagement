package Controllers.Teacher;

import UniversityManagement.Subject;
import UniversityManagement.Term_Subject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static UniversityManagement.Department.TTSlist;
import static UniversityManagement.User.mainUser;

public class SetRefSyllController {

    @FXML
    private Button backButton;

    @FXML
    private TextField refrence;

    @FXML
    private Button searchSubjectButton;

    @FXML
    private TextField searchSubjectField;

    @FXML
    private TextField syllabuses;

    @FXML
    private Button submitButton;


    @FXML
    void searchSubjectButtonOnClick(ActionEvent event) {
        //if searched subject is found on TTS list, show reference and syllabuses boxes to fill
        for (Term_Subject t : TTSlist) {
            if (t.teacher == mainUser & Objects.equals(t.subject.subjectTitle, searchSubjectField.getText())) {
                refrence.setVisible(true);
                syllabuses.setVisible(true);
                submitButton.setVisible(true);
            }
        }
    }


    @FXML
    void submitButtonOnClick(ActionEvent event) {
        //if submit is clicked, set subject's reference and syllabus
        for (Term_Subject t : TTSlist) {
            if (t.teacher == mainUser & Objects.equals(t.subject.subjectTitle, searchSubjectField.getText())) {
                t.subject.reference = refrence.getText();
                t.subject.setSyllabus(syllabuses.getText().split(","));
            }
        }

        //invisible the submit button
        submitButton.setVisible(false);
    }


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

}
