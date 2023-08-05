package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class MainMenuGUI extends JFrame {
    private static final String STATUS = "Please Make Your Selection";
    private JLabel statusLabel;
    private JPanel buttonPanel = new JPanel(new GridLayout(8, 2, 10, 10));
    protected App app;


    public MainMenuGUI() throws FileNotFoundException {
        super("My QUIZ");

        app = new App();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        statusLabel = new JLabel(STATUS);
        add(statusLabel, BorderLayout.NORTH);

        startQuiz();
        insertNewQuestion();
        deleteQuestion();
        showQuestion();
        showAnswer();
        save();
        load();
        quit();
        add(buttonPanel, BorderLayout.CENTER);

        pack();
        setVisible(true);


    }

    public MainMenuGUI(int x) throws FileNotFoundException {
        this.app = getApp();
    }

    public void startQuiz() {
        JButton startQuizButton = new JButton("StartQuiz");
        startQuizButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                app.startQuiz();
            }
        });
        buttonPanel.add(startQuizButton);
    }

    public void insertNewQuestion() {
        JButton insertNewQuestionButton = new JButton("Insert New Question");
        insertNewQuestionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InsertQuestionInterface userInputInterface;
                try {
                    userInputInterface = new InsertQuestionInterface();
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                userInputInterface.setVisible(true);
            }

        });
        buttonPanel.add(insertNewQuestionButton);

    }

    public void deleteQuestion() {
        JButton deleteQuestionButton = new JButton("Delete Question");

        deleteQuestionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonPanel.add(deleteQuestionButton);
    }

    public void showQuestion() {
        JButton showQuestionButton = new JButton("Show All Questions in Question Bank");

        showQuestionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                app.showquestionbank();
            }
        });
        buttonPanel.add(showQuestionButton);

    }

    public void showAnswer() {
        JButton showAnswerButton = new JButton("Show All Answers in Question Bank");

        showAnswerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                app.showanswers();
            }
        });
        buttonPanel.add(showAnswerButton);
    }

    public void save() {
        JButton saveButton = new JButton("Save Question Bank to File");

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                app.saveQuestionBank();
            }
        });
        buttonPanel.add(saveButton);
    }

    public void load() {
        JButton loadButton = new JButton("Load Question Bank from File");

        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                app.loadQuestionBank();
            }
        });
        buttonPanel.add(loadButton);
    }

    public void quit() {
        JButton quitButton = new JButton("Quit");

        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        buttonPanel.add(quitButton);
    }

    public App getApp() {
        return this.app;
    }


    public static void main(String[] args) throws FileNotFoundException {
        new MainMenuGUI();
    }
}