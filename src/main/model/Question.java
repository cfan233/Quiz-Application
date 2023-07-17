package model;

public class Question {
    private final String question;
    private final String correctanswer;
    private final int assignedpoints;


    public Question(String question, String correctanswer, int assignedpoints) {
        this.question = question;
        this.correctanswer = correctanswer;
        this.assignedpoints = assignedpoints;

    }

    public String getCorrectanswer() {
        return this.correctanswer;
    }


    public String getQuestion() {
        return this.question;
    }

    public int getAssignedpoints() {
        return this.assignedpoints;
    }
}
