package Controllers.Student;

import UniversityManagement.*;
import UniversityManagement.Subject;
import UniversityManagement.Term_Subject;
import UniversityManagement.User;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewClassesController implements Initializable {

    @FXML
    private Button backButton;

    @FXML
    private TextArea ViewClassesField;


    @FXML
    void backButtonOnClick(ActionEvent event) throws IOException {
        if (event.getSource().equals(backButton)) {
            switchToStdDash(event);
        }
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 1;
        for (Term_Subject t : Student.studentTTS) {
            stringBuilder.append(i + ". " + t.subject.subjectTitle + "\t" + t.teacher.name + " " + t.teacher.lastname
                    + "\t\t" + t.subject.reference + t.subject.getSyllabus() + "\t\t" +
                    t.subject.midtermDate.printDate() + "\t\t" + t.subject.finalDate.printDate() + "\n");
            i++;
        }
        ViewClassesField.setText(String.valueOf(stringBuilder));
    }
}
