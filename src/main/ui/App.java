package ui;

import model.ListOfQuestions;
import model.Question;

import java.util.Scanner;

// Quiz app
public class App {

    private int points;
    private ListOfQuestions questionBank;
    private Scanner input;

    //EFFECTS: initial quizapp with points being 0, blank questionbank, and runs the quiz application

    public App() {
        this.points = 0;
        questionBank = new ListOfQuestions();
        runQuiz();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    public void runQuiz() {
        boolean keepGoing = true;
        String inputString;

        while (keepGoing) {
            showMenu();
            Scanner scanner = new Scanner(System.in);
            inputString = null;
            inputString = scanner.nextLine();
            if (inputString.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(inputString);
            }
        }

    }

    // MODIFIES: this
    // EFFECTS: processes user command

    private void processCommand(String command) {
        if (command.equals("s")) {
            startQuiz();
        } else if (command.equals("i")) {
            insertquestionfromuser();
        } else if (command.equals("d")) {
            removequestionfromuser();
        } else if (command.equals("q")) {
            System.out.println("Have a good rest of your day");
        } else if (command.equals("sq")) {
            showquestionbank();
        } else if (command.equals("sa")) {
            showanswers();
        } else {
            System.out.println("Value entered is not valid");
        }
    }

    // MODIFIES: this
    // EFFECTS: user can insert questions to questionbank
    public void insertquestionfromuser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your question (String only)");
        String q = scanner.nextLine();
        if (!(questionBank.isquestioninbank(q))) {
            System.out.println("Please enter the corresponding answer for the question you have inserted "
                    + "(String only)");
            String a = scanner.nextLine();

            System.out.println("Please assign points from scale 1-10 for answering this question correctly "
                    + "(integer only)");
            int p = scanner.nextInt();

            Question newq = new Question(q, a, p);

            questionBank.addQuestion(newq);
        }
    }
    // MODIFIES: this
    // EFFECTS: user can remove questions to questionbank

    public void removequestionfromuser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the question you want to remove");
        String qremove = scanner.nextLine();
        questionBank.removeQuestionstring(qremove);
        System.out.println("The chosen question has been removed");

    }

    // EFFECTS: Display the questions in the questionbank
    public void showquestionbank() {
        if (questionBank.getListOfQuestions().isEmpty()) {
            System.out.println("There are no questions inside the question bank");
        } else {
            for (Question q : questionBank.getListOfQuestions()) {
                System.out.print(q.getQuestion());
            }
        }
    }

    // EFFECTS: Display the answers in the questionbank

    public void showanswers() {
        if (questionBank.getListOfQuestions().isEmpty()) {
            System.out.println("There are no questions inside the question bank");
        } else {
            for (Question q : questionBank.getListOfQuestions()) {
                System.out.print(q.getCorrectanswer());
            }
        }
    }


    // EFFECTS: Shows the menu to user
    public void showMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ts -> Start Quiz");
        System.out.println("\ti -> Insert New Question");
        System.out.println("\td -> Delete Question");
        System.out.println("\tq -> quit");
        System.out.println("\tsq -> Show All Questions in Question Bank");
        System.out.println("\tsa -> Show All Answers in Question Bank");
    }


    // EFFECTS: starts the quiz for the inputted questions
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
