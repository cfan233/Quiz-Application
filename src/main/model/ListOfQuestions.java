package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

// Citation: Teller APP, WorkRoomAPP
//https://github.students.cs.ubc.ca/CPSC210/TellerApp
//https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo


public class ListOfQuestions implements Writable {
    private ArrayList<Question> listOfQuestions;
    private String name;

    // EFFECTS: constructs an empty arraylist of question
    public ListOfQuestions(String name) {
        this.listOfQuestions = new ArrayList<Question>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Question> getListOfQuestions() {
        return this.listOfQuestions;
    }

    //REQIURES: question
    //MODIFIES: this
    //EFFECTS: add the question to the listofQuestions
    public void addQuestion(Question question) {
        this.listOfQuestions.add(question);
    }
    //REQIURES: question
    //MODIFIES: this
    //EFFECTS: remove the question to the listofQuestions

    public void removeQuestioncons(Question question) {
        this.listOfQuestions.remove(question);
    }

    //REQIURES: The String version of the quesiton
    //MODIFIES: this
    //EFFECTS: remove the question to the listofQuestions
    public void removeQuestionstring(String question) {
        for (Question q : this.listOfQuestions) {
            if (q.getQuestion().equals(question)) {
                this.listOfQuestions.remove(q);
            }
        }
    }


    //REQIURES: The String version of the quesiton
    //EFFECTS: produce true if the input question is in the bank false if not
    public boolean isquestioninbank(String ques) {
        for (Question q : getListOfQuestions()) {
            if (q.getQuestion().equals(ques)) {
                System.out.print("Sorry the question you are trying to implement is already "
                        + "in the question bank and the question bank does not allow duplicates");
                return true;
            }

        }
        return false;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("questions", listofqsToJson());
        return json;
    }

    // EFFECTS: returns questions in listofquestions as a JSON array
    private JSONArray listofqsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Question q : listOfQuestions) {
            jsonArray.put(q.toJson());
        }

        return jsonArray;
    }
}






