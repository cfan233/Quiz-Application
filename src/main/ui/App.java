package ui;

import model.ListOfQuestions;
import model.Question;
import model.QuestionBank;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    private int points;
    private QuestionBank questionBank;

    public App() {
        this.points = 0;
        questionBank = new QuestionBank();
    }
/*
    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (Question q: questionBank.getlistOfQuestion()) {
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

*/
}
