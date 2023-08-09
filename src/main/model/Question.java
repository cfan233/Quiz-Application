package model;

import org.json.JSONObject;
import persistence.Writable;

// Citation: Teller APP, WorkRoomAPP
//https://github.students.cs.ubc.ca/CPSC210/TellerApp
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo



public class Question implements Writable {
    private final String question;
    private final String correctanswer;
    private final int assignedpoints;

    //EFFECTS: constructs a question with user input of question correct answer and assignedpoints

    public Question(String question, String correctanswer, int assignedpoints) {
        this.question = question;
        this.correctanswer = correctanswer;
        this.assignedpoints = assignedpoints;

    }

    public String getCorrectanswer() {
        return this.correctanswer;
    }

    public String getCorrectanswer1() {
        EventLog.getInstance().logEvent(new Event("Answers in the bank are shown"));
        return this.correctanswer;
    }


    public String getQuestion() {
        return this.question;
    }

    public String getQuestion1() {
        EventLog.getInstance().logEvent(new Event("Questions in the bank are shown"));
        return this.question;
    }

    public int getAssignedpoints() {
        return this.assignedpoints;
    }

    public int getAssignedpoints1() {
        EventLog.getInstance().logEvent(new Event("Assigned points are shown"));
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
