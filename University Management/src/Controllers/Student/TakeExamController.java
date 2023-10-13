package Controllers.Student;

import UniversityManagement.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class TakeExamController {

    Exam tempExam;

    @FXML
    private Button backButton;

    @FXML
    private TextArea examProblems;

    @FXML
    private Button searchSubjectButton;

    @FXML
    private TextField searchSubjectField;

    @FXML
    private Button submitButton;

    @FXML
    private TextField submitMsg;

    @FXML
    private TextField examTitleField;

    @FXML
    private TextField problemNo;

    @FXML
    private TextField problemTitle;

    @FXML
    private RadioButton falseAnswer;

    @FXML
    private RadioButton trueAnswer;

    @FXML
    private RadioButton answer1;

    @FXML
    private RadioButton answer2;

    @FXML
    private RadioButton answer3;

    @FXML
    private RadioButton answer4;

    @FXML
    private Button nextButton;

    @FXML
    void backButtonOnClick(ActionEvent event) throws IOException {
        if (event.getSource().equals(backButton)) {
            switchToStdDash(event);
        }
    }


    //search for subject and process it
    @FXML
    void searchSubjectButtonOnClick(ActionEvent event) {
        //search for required subject in subject list
        for (Subject s : User.subjectsList) {
            if (Objects.equals(searchSubjectField.getText(), s.subjectTitle)) {

                //if found, set these fields to visible
                examTitleField.setVisible(true);
                examTitleField.setText(s.exam.examTitle);
                problemNo.setVisible(true);
                problemTitle.setVisible(true);
                nextButton.setVisible(true);

                //save exam for later
                tempExam = s.exam;

                //print the first question
                problemNo.setText(String.valueOf(1));
                problemTitle.setText(tempExam.problemList.get(0).problemTitle);
                loadProblem(tempExam.problemList.get(0).solutionType);
            }
        }

    }


    //load the problem's blank space based on its type
    public void loadProblem(SolutionType solutionType) {
        if (solutionType == SolutionType.TEST) {
            answer1.setVisible(true);
            answer2.setVisible(true);
            answer3.setVisible(true);
            answer4.setVisible(true);
        } else if (solutionType == SolutionType.TRUE_FALSE) {
            falseAnswer.setVisible(true);
            trueAnswer.setVisible(true);
        } else {
            examProblems.setVisible(true);
        }
    }

    //save the exam and invisible its attributes
    @FXML
    void submitButtonOnClick(ActionEvent event) {
        examTitleField.setVisible(false);
        problemNo.setVisible(false);
        problemTitle.setVisible(false);
        examProblems.setVisible(false);
        submitMsg.setVisible(true);
        submitButton.setVisible(false);
    }


    //use static int to iterate on problems and set the view, based on load problem
    static int i = 2;

    @FXML
    void nextButtonOnClick(ActionEvent event) {
        //clear the previous answer
        examProblems.setVisible(false);
        examProblems.clear();
        answer1.setVisible(false);
        answer1.setSelected(false);
        answer2.setVisible(false);
        answer2.setSelected(false);
        answer3.setVisible(false);
        answer3.setSelected(false);
        answer4.setVisible(false);
        answer4.setSelected(false);
        falseAnswer.setVisible(false);
        falseAnswer.setSelected(false);
        trueAnswer.setVisible(false);
        trueAnswer.setSelected(false);

        //print the next question
        problemNo.setText(String.valueOf(i));
        problemTitle.setText(tempExam.problemList.get(i - 1).problemTitle);
        loadProblem(tempExam.problemList.get(i - 1).solutionType);


        i++;

        //if problems are finished, clear everything and show submit button
        if (i > tempExam.problemList.size()) {
            nextButton.setVisible(false);
            submitButton.setVisible(true);
            examProblems.setVisible(false);
            answer1.setVisible(false);
            answer2.setVisible(false);
            answer3.setVisible(false);
            answer4.setVisible(false);
            falseAnswer.setVisible(false);
            trueAnswer.setVisible(false);

            //set i to 1 for the next time
            i = 1;
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

}
