package Controllers.Department;

import UniversityManagement.Department;
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
import org.omg.PortableInterceptor.INACTIVE;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class DepartmentDashboardController implements Initializable {

    @FXML
    private Button addStdButton;

    @FXML
    private Button addTchrButton;

    @FXML
    private Button viewStdButton;

    @FXML
    private Button viewTchrButton;

    @FXML
    private Button departmentExitButton;

    @FXML
    private Button addTermButton;

    @FXML
    private Button ViewTermButton;

    @FXML
    private TextArea welcomeField;

    @FXML
    private TextField localDate;

    @FXML
    void addStdButtonOnClick(ActionEvent event) throws IOException {
        switchToAddStudent(event);
    }


    @FXML
    void addTchrButtonOnClick(ActionEvent event) throws IOException {
        if (event.getSource() == addTchrButton) {
            switchToAddTeacher(event);
        }
    }


    @FXML
    void viewStdButtonOnClick(ActionEvent event) throws IOException {
        if (event.getSource() == viewStdButton) {
            switchToViewStudent(event);
        }
    }


    @FXML
    void viewTchrButtonOnClick(ActionEvent event) throws IOException {
        switchToViewTeacher(event);
    }


    @FXML
    void addTermButtonOnClick(ActionEvent event) throws IOException {
        switchToAddTerm(event);
    }


    @FXML
    void ViewTermButtonOnClick(ActionEvent event) throws IOException {
        switchToViewTerm(event);
    }


    @FXML
    void departmentExitButtonOnClick(ActionEvent event) throws IOException {
        if (event.getSource() == departmentExitButton) {
            switchToLogIn(event);
        }
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


    public void switchToAddStudent(javafx.event.ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/Controllers/Department/AddStudent.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void switchToViewStudent(javafx.event.ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/Controllers/Department/ViewStudent.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void switchToAddTeacher(javafx.event.ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/Controllers/Department/AddTeacher.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void switchToViewTerm(javafx.event.ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/Controllers/Department/ViewTerm.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void switchToAddTerm(javafx.event.ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/Controllers/Department/AddTerm.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void switchToViewTeacher(javafx.event.ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/Controllers/Department/ViewTeacher.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //welcome msg
        welcomeField.setText("Dear admin, welcome!\nChoose any option from the bar on right.");

        //date bar
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        localDate.setText("Today is: " + dtf.format(now));
    }
}
