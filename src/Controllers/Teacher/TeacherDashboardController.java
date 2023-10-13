package Controllers.Teacher;

import UniversityManagement.Teacher;
import UniversityManagement.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class TeacherDashboardController implements Initializable {

    @FXML
    private Button ClassesButton;

    @FXML
    private Button addExamButton;

    @FXML
    private Button teacherExitButton;

    @FXML
    private Button viewStdButton;

    @FXML
    private TextArea welcomeField;

    @FXML
    private TextField localDate;

    @FXML
    void ClassesListButtonOnClick(ActionEvent event) throws IOException {
        if (event.getSource().equals(ClassesButton)) {
            switchToClassesList(event);
        }
    }


    @FXML
    void addExamButtonOnClick(ActionEvent event) throws IOException {
        if (event.getSource().equals(addExamButton)) {
            switchToAddExam(event);
        }
    }


    @FXML
    void teacherExitButtonOnClick(ActionEvent event) throws IOException {
        if (event.getSource().equals(teacherExitButton)) {
            switchToLogIn(event);
        }
    }


    @FXML
    void viewStdButtonOnClick(ActionEvent event) throws IOException {
        if (event.getSource().equals(viewStdButton)) {
            switchViewStdofClass(event);
        }
    }


    @FXML
    void setRefSyllButtonOnClick(ActionEvent event) throws IOException {
        switchSetSubject(event);
    }


    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToLogIn(javafx.event.ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/Controllers/Main/LogIn.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void switchToClassesList(javafx.event.ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/Controllers/Teacher/ClassesList.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void switchToAddExam(javafx.event.ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/Controllers/Teacher/AddExam.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void switchViewStdofClass(javafx.event.ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/Controllers/Teacher/ViewStdofClass.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void switchSetSubject(javafx.event.ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/Controllers/Teacher/SetRefSyll.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //welcome msg
        welcomeField.setText("Dear " + User.mainUser.name + " " + User.mainUser.lastname + ", welcome!\n" +
                "Choose any option from the bar on right.");

        //date bar
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        localDate.setText("Today is: " + dtf.format(now));
    }
}
