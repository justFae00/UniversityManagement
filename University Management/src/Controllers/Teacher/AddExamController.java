package Controllers.Teacher;

import UniversityManagement.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class AddExamController extends Teacher {

    Teacher teacher = new Teacher();
    static ArrayList<Problem> tempProblemList = new ArrayList<>();

    @FXML
    private Button ExamSubmitButton;

    @FXML
    private Button ExitButton;

    @FXML
    private RadioButton FalseSolution;

    @FXML
    private RadioButton TFcheck;

    @FXML
    private RadioButton TrueSolution;

    @FXML
    private RadioButton descriptiveCheck;

    @FXML
    private TextField descriptiveSolution;

    @FXML
    private TextField examTitleField;

    @FXML
    private RadioButton fillBlankCheck;

    @FXML
    private TextField fillBlankSolution;

    @FXML
    private TextField problemNo;

    @FXML
    private TextField problemTitle;

    @FXML
    private RadioButton solution1;

    @FXML
    private RadioButton solution2;

    @FXML
    private RadioButton solution3;

    @FXML
    private RadioButton solution4;

    @FXML
    private RadioButton testCheck;

    @FXML
    private TextField subjectTitleField;


    //use static int, since we want to call this function from different locations and use the i
    static int i = 1;


    @FXML
    void ExamSubmitButtonOnClick(ActionEvent event) {

        //set problems based on their type (set from the choice boxes)
        Problem problem = new Problem(problemTitle.getText());
        if (testCheck.isSelected()) {
            if (solution1.isSelected()) {
                problem.setProblem(1);
            }
            if (solution2.isSelected()) {
                problem.setProblem(2);
            }
            if (solution3.isSelected()) {
                problem.setProblem(3);
            }
            if (solution4.isSelected()) {
                problem.setProblem(4);
            }
        }
        if (fillBlankCheck.isSelected()) {
            problem.setProblem(fillBlankSolution.getText().toCharArray());
        }
        if (descriptiveCheck.isSelected()) {
            problem.setProblem(descriptiveSolution.getText());
        }
        if (TFcheck.isSelected()) {
            problem.setProblem(!FalseSolution.isSelected());
        }

        //save the problem in problem list
        tempProblemList.add(problem);

        //continue getting problems
        i++;
        problemNo.setText(String.valueOf(i));

        //reset to take new problems
        problemTitle.clear();
        descriptiveCheck.setSelected(false);
        fillBlankCheck.setSelected(false);
        testCheck.setSelected(false);
        TFcheck.setSelected(false);
        TrueSolution.setSelected(false);
        FalseSolution.setSelected(false);
        solution1.setSelected(false);
        solution2.setSelected(false);
        solution3.setSelected(false);
        solution4.setSelected(false);
        fillBlankSolution.clear();
        descriptiveSolution.clear();
    }


    @FXML
    void ExitButtonOnClick(ActionEvent event) throws IOException {
        if (event.getSource().equals(ExitButton)) {
            //make a new exam
            Exam exam = new Exam(examTitleField.getText());

            //add problems to exam
            exam.setProblems(tempProblemList);
            for (Subject s : subjectsList) {
                if (Objects.equals(subjectTitleField.getText(), s.subjectTitle)) {
                    exam.examTitle = examTitleField.getText();
                    s.setExam(exam);
                }
            }

            //add exam to its teacher
            teacher.addExam(exam);

            switchToTchrDash(event);
        }
    }


    @FXML
    void FalseSolutionOnClick(ActionEvent event) {

    }


    //if question is of true false type
    @FXML
    void TFcheckOnClick(ActionEvent event) {
        if (event.getSource().equals(TFcheck)) {
            TrueSolution.setVisible(true);
            FalseSolution.setVisible(true);
        }
    }


    @FXML
    void TrueSolutionOnClick(ActionEvent event) {

    }


    //if question is of descriptive type
    @FXML
    void descriptiveCheckOnClick(ActionEvent event) {
        if (event.getSource().equals(descriptiveCheck)) {
            descriptiveSolution.setVisible(true);
        }
    }


    //if question is of fill blank type
    @FXML
    void fillBlankCheckOnClick(ActionEvent event) {
        if (event.getSource().equals(fillBlankCheck)) {
            fillBlankSolution.setVisible(true);
        }
    }


    @FXML
    void solution1OnClick(ActionEvent event) {

    }


    @FXML
    void solution3OnClick(ActionEvent event) {

    }


    @FXML
    void solution4OnClick(ActionEvent event) {

    }


    //if question is of test type
    @FXML
    void testCheckOnClick(ActionEvent event) {
        if (event.getSource().equals(testCheck)) {
            solution1.setVisible(true);
            solution2.setVisible(true);
            solution3.setVisible(true);
            solution4.setVisible(true);
        }
    }


    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToTchrDash(javafx.event.ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/Controllers/Teacher/TeacherDashboard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
