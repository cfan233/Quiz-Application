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

    public void removeQuestioncons(Question question) {
        this.listOfQuestions.remove(question);
    }

    public void removeQuestionstring(String question) {
        for (Question q : this.listOfQuestions) {
            if (q.getQuestion().equals(question)) {
                this.listOfQuestions.remove(q);
            }
        }
    }




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
}





