package model;

import java.util.ArrayList;

public class ListOfQuestions {
    private ArrayList<Question> listOfQuestions;

    public ListOfQuestions() {
        this.listOfQuestions = new ArrayList<Question>();
    }

    public ArrayList<Question> getListOfQuestions() {
        return this.listOfQuestions;
    }

    public void addQuestion(Question question) {
        this.listOfQuestions.add(question);
    }

    public void removeQuestion(Question question) {
        this.listOfQuestions.remove(question);
    }
}





