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
        EventLog.getInstance().logEvent(new Event("User input answer is checked against the correct answer "
                + "or answer is being showed in pop up window"));
        return this.correctanswer;
    }


    public String getQuestion() {
        EventLog.getInstance().logEvent(new Event("Question is removed or "
                + "question is showing the question bank"));
        return this.question;
    }

    public int getAssignedpoints() {
        EventLog.getInstance().logEvent(new Event("Points are added or assigned points are shown"));
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
