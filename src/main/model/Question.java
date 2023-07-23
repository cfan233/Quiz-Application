package model;

import org.json.JSONObject;
import persistence.Writable;

// constructs questions with question, answer, and points
public class Question implements Writable {
    private final String question;
    private final String correctanswer;
    private final int assignedpoints;
    //REQIURES: question and answer both in string, and an assignedpoints 0-10
    //EFFECTS: constructs a question with user input of question correct answer and assignedpoints

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

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("question", question);
        json.put("correctanswer", correctanswer);
        json.put("assignedpoints", assignedpoints);
        return json;
    }
}
