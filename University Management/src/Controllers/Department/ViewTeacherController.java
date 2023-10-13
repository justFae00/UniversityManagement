package Controllers.Department;

import UniversityManagement.Student;
import UniversityManagement.Teacher;
import UniversityManagement.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewTeacherController implements Initializable {

    @FXML
    private TextArea ViewTchrField;

    @FXML
    void BackButtonOnClick(ActionEvent event) throws IOException {
        switchToDpDash(event);
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 1;
        for (Teacher t : User.teachersList) {
            stringBuilder.append(i + ". " + t.name + "  " + t.lastname + "\t\t" + t.getFields() + "\n");
            i++;
        }
        ViewTchrField.setText(String.valueOf(stringBuilder));
    }

}
