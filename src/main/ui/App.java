package ui;

import model.ListOfQuestions;
import model.Question;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private ListOfQuestions questionBank;
    private int points;

    public App() {
        this.questionBank = new ListOfQuestions();
        this.points = 0;
    }

    public ListOfQuestions getlistOfQuestion() {
        return this.questionBank;
    }

    public int getPoints() {
        return this.points;
    }

    public void showquestion() {
        for (Question q : questionBank.getListOfQuestions()) {
            System.out.print(q.getQuestion());
        }
    }

    public void showanswer() {
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

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (Question q: questionBank.getListOfQuestions()) {
            System.out.println(q.getQuestion());
            System.out.println("Please insert your answer: ");
            String inputanswer = scanner.nextLine();

            if (inputanswer.equals(q.getCorrectanswer())) {
                System.out.println("Congrats");
                points += q.getAssignedpoints();
                System.out.println("Total Points: " + this.points);
            } else {
                System.out.println("Incorrect");
                System.out.println("Total Points: " + this.points);
            }
        }
        System.out.println("You have finished the quiz, your total score is " + this.points);
    }

}
