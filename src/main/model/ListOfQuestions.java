package model;

import java.util.ArrayList;



// EFFECTS: constructs an empty arraylist of question
public class ListOfQuestions {
    private ArrayList<Question> listOfQuestions;

    public ListOfQuestions() {
        this.listOfQuestions = new ArrayList<Question>();
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
}





