package Controllers.Student;

import UniversityManagement.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class JoinClassController extends Student {
    static Subject tempSubject;
    static Term_Subject tempTTS;

    @FXML
    private TextField alertBox;

    @FXML
    private Button backButton;

    @FXML
    private Button searchSubjectButton;

    @FXML
    private TextField searchSubjectField;

    @FXML
    private RadioButton subjectChoice1;

    @FXML
    private RadioButton subjectChoice2;

    @FXML
    private RadioButton subjectChoice3;

    @FXML
    private Button submitButton;

    @FXML
    private TextField bar;

    @FXML
    void backButtonOnClick(ActionEvent event) throws IOException {
        if (event.getSource().equals(backButton)) {
            switchToStdDash(event);
        }
    }


    @FXML
    void searchSubjectButtonOnClick(ActionEvent event) {
        //search for subject in TTS list
        if (!searchSubjectField.getText().isEmpty()) {
            for (Term_Subject i : Department.TTSlist) {

                //if a subject is found in TTS, show its info in a new checkbox
                if (Objects.equals(i.getSubject().subjectTitle, searchSubjectField.getText())) {
                    tempSubject = i.subject;
                    submitButton.setVisible(true);
                    alertBox.setVisible(true);
                    subjectChoice1.setVisible(true);
                    bar.setDisable(false);
                    subjectChoice1.setText(i.subject.subjectTitle + "\t\t" + i.subject.midtermDate.printDate()
                            + "\t\t" + i.subject.finalDate.printDate() + "\t\t" + i.teacher.name + " " + i.teacher.lastname);

                    //save the TTS for later
                    tempTTS = i;
                }
            }
        }
    }


    @FXML
    void subjectChoice1OnClick(ActionEvent event) {

    }


    @FXML
    void subjectChoice2OnClick(ActionEvent event) {

    }


    @FXML
    void subjectChoice3OnClick(ActionEvent event) {

    }


    //if submit is clicked, set choices to invisible and add tempTTS's subject to student's
    @FXML
    void submitButtonOnClick(ActionEvent event) {
        alertBox.setVisible(false);
        subjectChoice1.setVisible(false);
        subjectChoice1.setSelected(false);
        searchSubjectField.clear();
        submitButton.setVisible(false);
        bar.setDisable(true);

        studentTTS.add(tempTTS);
        stdSubjectsList.add(tempSubject);
    }


    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToStdDash(javafx.event.ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/Controllers/Student/StudentDashboard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
