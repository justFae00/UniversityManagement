package UniversityManagement;

public class Problem {
    public String problemTitle;
    public SolutionType solutionType;
    public String DescriptiveSolution;
    public boolean TFSolution;
    public char[] FillSolution;
    public int TestSolution;

    public Problem(String title){
        problemTitle = title;
    }

    //setting problem based on their type (declared as enum)
    public void setProblem(boolean solution){
        TFSolution = solution;
        solutionType = SolutionType.TRUE_FALSE;
    }

    public void setProblem(char[] solution){
        FillSolution = solution;
        solutionType = SolutionType.FILL_OUT;
    }

    public void setProblem(int solution){
        TestSolution = solution;
        solutionType = SolutionType.TEST;
    }

    public void setProblem(String solution){
        DescriptiveSolution = solution;
        solutionType = SolutionType.DESCRIPTIVE;
    }
}
