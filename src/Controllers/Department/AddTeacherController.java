package Controllers.Department;

import UniversityManagement.Department;
import UniversityManagement.Teacher;
import UniversityManagement.User;
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

public class AddTeacherController {
    Department department = Department.getInstance();

    @FXML
    private Button AddTchrBackButton;

    @FXML
    private Button AddTchrSubmitButton;

    @FXML
    private TextField FillTchrFieldField;

    @FXML
    private TextField FillTchrLastNameField;

    @FXML
    private TextField FillTchrNameField;

    @FXML
    private TextField FillTchrPassField;

    @FXML
    private TextField FillTchrUsernameField;

    @FXML
    void AddTchrBackButtonOnClick(ActionEvent event) throws IOException {
        if (event.getSource() == AddTchrBackButton) {
            switchToDpDash(event);
        }
    }


    @FXML
    void AddTchrSubmitButtonOnClick(ActionEvent event) {
        department.addTeacher(FillTchrUsernameField.getText(), FillTchrPassField.getText(), FillTchrNameField.getText(),
                FillTchrLastNameField.getText());
        for (Teacher t : User.teachersList) {
            if (Objects.equals(t.name, FillTchrNameField.getText())) {
                t.setFields(FillTchrLastNameField.getText().split(","));
            }
        }
    }


    @FXML
    void FillTchrFieldFieldOnClick(ActionEvent event) {

    }


    @FXML
    void FillTchrLastNameFieldOnclick(ActionEvent event) {

    }


    @FXML
    void FillTchrNameFieldOnClick(ActionEvent event) {

    }


    @FXML
    void FillTchrPassFieldOnClick(ActionEvent event) {

    }


    @FXML
    void FillTchrUsernameFieldOnClick(ActionEvent event) {

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

}
