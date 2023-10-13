package Controllers.Student;

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

public class StudentDashboardController implements Initializable {

    @FXML
    private Button StdClassesButton;

    @FXML
    private Button joinNewClass;

    @FXML
    private Button stdExitButton;

    @FXML
    private Button takeExamButton;

    @FXML
    private TextArea welcomeBox;

    @FXML
    private TextField localDate;

    @FXML
    void StdClassesButtonOnClick(ActionEvent event) throws IOException {
        if (event.getSource().equals(StdClassesButton)) {
            switchToViewClss(event);
        }
    }


    @FXML
    void joinNewClassOnClick(ActionEvent event) throws IOException {
        if (event.getSource().equals(joinNewClass)) {
            switchToJoinClss(event);
        }
    }


    @FXML
    void stdExitButtonOnClick(ActionEvent event) throws IOException {
        if (event.getSource().equals(stdExitButton)) {
            switchToLogIn(event);
        }
    }


    @FXML
    void takeExamButtonOnClick(ActionEvent event) throws IOException {
        switchToTakeExam(event);
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


    public void switchToViewClss(javafx.event.ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/Controllers/Student/ViewClasses.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void switchToJoinClss(javafx.event.ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/Controllers/Student/JoinClass.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void switchToTakeExam(javafx.event.ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/Controllers/Student/TakeExam.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //welcome msg
        welcomeBox.setText("Dear " + User.mainUser.name + " " + User.mainUser.lastname + ", welcome!\n" +
                "Choose any option from the bar on right.");

        //date bar
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        localDate.setText("Today is: " + dtf.format(now));
    }
}