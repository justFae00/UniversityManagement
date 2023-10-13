package Controllers.Department;

import UniversityManagement.Date;
import UniversityManagement.Term;
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

public class AddTermController {

    @FXML
    private Button BackButton;

    @FXML
    private TextField EndDay;

    @FXML
    private TextField EndMonth;

    @FXML
    private TextField GradeDay;

    @FXML
    private TextField GradeMonth;

    @FXML
    private Button SubmitButton;

    @FXML
    private TextField beginDay;

    @FXML
    private TextField beginMonth;

    @FXML
    private TextField beginYear;

    @FXML
    private TextField endYear;

    @FXML
    private TextField gradeYear;

    @FXML
    private TextField termTitleField;


    @FXML
    void BackButtonOnClick(ActionEvent event) throws IOException {
        switchToDpDash(event);
    }


    @FXML
    void SubmitButtonOnClick(ActionEvent event) {
        Term term = new Term(termTitleField.getText(), new Date(GradeDay.getText(), GradeMonth.getText(), gradeYear.getText()),
                new Date(beginDay.getText(), beginMonth.getText(), beginYear.getText()),
                new Date(EndDay.getText(), EndMonth.getText(), endYear.getText()));
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
