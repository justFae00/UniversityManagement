package Controllers.Department;

import UniversityManagement.Department;
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


public class AddStudentController {

    @FXML
    private Button AddStdBackButton;

    @FXML
    private Button AddStdSubmitButton;

    @FXML
    private TextField FillStdLastNameField;

    @FXML
    private TextField FillStdNameField;

    @FXML
    private TextField FillStdNoField;

    @FXML
    private TextField FillStdPassField;

    @FXML
    private TextField FillStdUsernameField;


    @FXML
    void AddStdBackButtonOnClick(ActionEvent event) throws IOException {
        if (event.getSource() == AddStdBackButton) {
            switchToDpDash(event);
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


    @FXML
    void FillStdLastNameFieldOnclick(ActionEvent event) {

    }


    @FXML
    void FillStdNameFieldOnClick(ActionEvent event) {

    }


    @FXML
    void FillStdNoFieldOnClick(ActionEvent event) {

    }


    @FXML
    void FillStdPassFieldOnClick(ActionEvent event) {

    }


    @FXML
    void FillStdUsernameFieldOnClick(ActionEvent event) {

    }


    @FXML
    void AddStdSubmitButtonOnClick(ActionEvent event) {
        if (event.getSource() == AddStdSubmitButton) {
            Department.getInstance().addStudent(FillStdUsernameField.getText(), FillStdPassField.getText(), FillStdNameField.getText(),
                    FillStdLastNameField.getText(), Integer.parseInt(FillStdNoField.getText()));
        }
    }


}
