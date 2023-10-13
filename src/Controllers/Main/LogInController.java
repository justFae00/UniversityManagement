package Controllers.Main;

import UniversityManagement.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.event.InputMethodEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LogInController extends Data implements Initializable{

    @FXML
    private javafx.scene.control.Button LogInButton;

    @FXML
    private javafx.scene.control.PasswordField LogInPassword;

    @FXML
    private javafx.scene.control.TextField LogInUsername;


    //log in process
    public void lgButtonClicked(javafx.event.ActionEvent actionEvent) throws IOException {

        //check if password and username are equal to admin
        if (LogInUsername.getText().equals("admin") & LogInPassword.getText().equals("admin")) {
            User.mainUser = Department.getInstance();
            switchToDpDash(actionEvent);
        }

        //check if the information match with a teacher's
        for (Teacher t : User.getTeachersList()) {
            if (LogInUsername.getText().equals(t.username) & LogInPassword.getText().equals(t.password)) {
                User.mainUser = t;
                switchToTchrDash(actionEvent);
            }
        }

        //check if the information match with a student's
        for (Student s : User.getStudentsList()) {
            if (LogInUsername.getText().equals(s.username) & LogInPassword.getText().equals(s.password)) {
                User.mainUser = s;
                switchToStdDash(actionEvent);
            }
        }
    }


    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToDpDash(javafx.event.ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/Controllers/Department/DepartmentDashboard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void switchToTchrDash(javafx.event.ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/Controllers/Teacher/TeacherDashboard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void switchToStdDash(javafx.event.ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/Controllers/Student/StudentDashboard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}