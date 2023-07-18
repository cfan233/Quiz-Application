package model;

import java.util.Scanner;

public class QuestionBank {
    private ListOfQuestions questionBank;

    public QuestionBank() {
        this.questionBank = new ListOfQuestions();

    }

    public ListOfQuestions getlistOfQuestion() {
        return this.questionBank;
    }



    public void showquestionbank() {
        for (Question q : questionBank.getListOfQuestions()) {
            System.out.print(q.getQuestion());
        }
    }

    public void showanswers() {
        for (Question q : questionBank.getListOfQuestions()) {
            System.out.println(q.getCorrectanswer());
        }
    }

    public void addNewQuestion(Question question) {
        for (Question q : questionBank.getListOfQuestions()) {
            if (q.equals(question)) {
                System.out.println("Sorry the question you are trying to implement is already "
                        + "in the question bank and the question bank does not allow duplicates");
                questionBank.removeQuestion(question);
                break;
            }

        }
        questionBank.addQuestion(question);
    }

    public void removeQuestion(Question question) {
        questionBank.removeQuestion(question);
    }

}
