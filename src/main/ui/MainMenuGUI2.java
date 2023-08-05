package ui;

import model.Question;
import ui.imagerelated.Questionhasbeenaddedimage;
import ui.imagerelated.SuccessfulPage;
import ui.imagerelated.Unsuccessfulpage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class MainMenuGUI2 extends JFrame {
    private static final String STATUS = "Please Make Your Selection";
    private JLabel statusLabel;
    private JPanel buttonPanel = new JPanel(new GridLayout(9, 2, 10, 10));
    protected App app = new App();

    //all fields for insert question:
    private static String STATUSiq = "Please input the appropriate values";
    private JLabel statusLabeliq;
    private JPanel buttonPaneliq = new JPanel(new GridLayout(4, 2, 10, 10));

    private JTextField questioninput;
    private JTextField answerinput;
    private JTextField scoreinput;
    private JButton submitB;

    private JFrame insertqframe;
    private int count;

    //startquiz fields
    private int points = 0;
    private JLabel statusLabelsq = new JLabel("Please insert your answer: ");
    private JLabel pointsLabel = new JLabel("Total Points: " + points);
    private JLabel questionlabel = new JLabel();
    private JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

    private List<JTextField> useranswer = new ArrayList<>();
    private JButton submitBsq;
    private int qnum = 0;
    private JFrame startqframe;



    public MainMenuGUI2() throws FileNotFoundException {
        super("My QUIZ");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        statusLabel = new JLabel(STATUS);
        add(statusLabel, BorderLayout.NORTH);

        startQuiz();
        insertNewQuestion();
        deleteQuestion();
        showQuestion();
        showAnswer();
        showPoints();
        save();
        load();
        quit();
        add(buttonPanel, BorderLayout.CENTER);

        pack();
        setVisible(true);


    }

    public void startQuiz() {
        JButton startQuizButton = new JButton("StartQuiz");
        startQuizButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startQuizInterface();
            }
        });
        buttonPanel.add(startQuizButton);
    }

    public void insertNewQuestion() {
        JButton insertNewQuestionButton = new JButton("Insert New Question");
        insertNewQuestionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (count == 0) {
                    insertQuestionInterface();
                    count++;
                } else {
                    insertqframe.setVisible(true);
                }
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
                qbankqshower();
            }
        });
        buttonPanel.add(showQuestionButton);

    }

    public void qbankqshower() {
        JFrame showqframe = new JFrame("All Question in Bank");
        showqframe.setTitle("All Question in Bank");
        showqframe.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        showqframe.setSize(300, 200);

        int numquestion = 1;

        List<String> qsinstring = new ArrayList<>();

        for (Question q : app.questionBank.getListOfQuestions()) {

            String qinstring = q.getQuestion();
            qsinstring.add("Question" + String.valueOf(numquestion) + " : " + qinstring);
            numquestion++;
        }
        JLabel qlabel = new JLabel(qsinstring.toString());
        showqframe.add(qlabel);
        showqframe.setVisible(true);

    }

    public void showAnswer() {
        JButton showAnswerButton = new JButton("Show All Answers in Question Bank");

        showAnswerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                qbankashower();
            }
        });
        buttonPanel.add(showAnswerButton);
    }

    public void qbankashower() {
        JFrame showqframe = new JFrame("All Question in Bank");
        showqframe.setTitle("All Question in Bank");
        showqframe.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        showqframe.setSize(300, 200);

        int numquestion = 1;

        List<String> qsinstring = new ArrayList<>();

        for (Question q : app.questionBank.getListOfQuestions()) {

            String qinstring = q.getCorrectanswer();
            qsinstring.add("Answer" + String.valueOf(numquestion) + " : " + qinstring);
            numquestion++;
        }
        JLabel qlabel = new JLabel(qsinstring.toString());
        showqframe.add(qlabel);
        showqframe.setVisible(true);

    }

    public void showPoints() {
        JButton showPointsButton = new JButton("Show All Assigned Points in Question Bank");

        showPointsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                qbanksshower();
            }
        });
        buttonPanel.add(showPointsButton);

    }

    public void qbanksshower() {
        JFrame showqframe = new JFrame("All Question in Bank");
        showqframe.setTitle("All Question in Bank");
        showqframe.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        showqframe.setSize(300, 200);

        int numquestion = 1;

        List<String> qsinstring = new ArrayList<>();

        for (Question q : app.questionBank.getListOfQuestions()) {

            int qinstring = q.getAssignedpoints();
            qsinstring.add("Question" + String.valueOf(numquestion) + " : " + qinstring + " points");
            numquestion++;
        }
        JLabel qlabel = new JLabel(qsinstring.toString());
        showqframe.add(qlabel);
        showqframe.setVisible(true);

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

    public void insertQuestionInterface() {
        insertqframe = new JFrame("Insert Question");
        insertqframe.setDefaultCloseOperation(HIDE_ON_CLOSE);

        statusLabeliq = new JLabel(STATUSiq);
        insertqframe.add(statusLabeliq, BorderLayout.NORTH);
        insertqframe.add(buttonPaneliq, BorderLayout.CENTER);
        inputQ();
        inputA();
        inputS();
        submitButton();

        insertqframe.add(buttonPaneliq);

        insertqframe.pack();
        insertqframe.setVisible(true);
    }

    public void inputQ() {
        JLabel labelforinputq = new JLabel("Please enter your question:");
        questioninput = new JTextField(50);
        buttonPaneliq.add(labelforinputq);
        buttonPaneliq.add(questioninput);
    }

    public void inputA() {
        JLabel labelforinputa = new JLabel("Please enter the corresponding answer for the question "
                + "you have inserted");
        answerinput = new JTextField(50);
        buttonPaneliq.add(labelforinputa);
        buttonPaneliq.add(answerinput);
    }

    public void inputS() {
        JLabel labelforinputS = new JLabel("Please assign points from scale 1-10 for answering this "
                + "question correctly " + "(integer only)");
        scoreinput = new JTextField(50);
        buttonPaneliq.add(labelforinputS);
        buttonPaneliq.add(scoreinput);

    }

    public void submitButton() {
        submitB = new JButton("Submit");
        submitB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insertQreqiurement();
            }
        });
        buttonPaneliq.add(new JLabel());
        buttonPaneliq.add(submitB);
    }

    public void insertQreqiurement() {
        String questionstring = questioninput.getText();
        String anwserstring = answerinput.getText();
        int scoreint;
        try {
            scoreint = Integer.parseInt(scoreinput.getText());
            if (!(app.questionBank.isquestioninbank(questionstring))) {
                if (!(scoreint < 1 || scoreint > 10)) {
                    Question newq = new Question(questionstring, anwserstring, scoreint);
                    app.questionBank.addQuestion(newq);
                    new Questionhasbeenaddedimage();
                } else {
                    statusLabeliq.setText("Integer input is not within the bound 1-10");
                }
            } else {
                statusLabeliq.setText("Sorry the question you are trying to implement is already in the "
                        + "question bank and the question bank does not allow duplicates");
                questioninput.setText("");
            }
        } catch (NumberFormatException c) {
            statusLabeliq.setText("Please enter integer");
        }
    }



    public void startQuizInterface() {
        startqframe = new JFrame();
        startqframe.setTitle("Start Quiz");

        startqframe.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        startqframe.setSize(400, 200);

        panel.add(statusLabelsq, BorderLayout.NORTH);
        panel.add(pointsLabel, BorderLayout.NORTH);
        panel.add(questionlabel,  BorderLayout.CENTER);



        initializetextbox();
        submitButtonsq();
        showq(qnum);
        startqframe.add(panel);
        pack();
        startqframe.setVisible(true);
    }

    public void initializetextbox() {
        for (Question q : app.questionBank.getListOfQuestions()) {
            JTextField textField = new JTextField(10);
            useranswer.add(textField);
        }
    }

    public void showq(int indexnum) {
        String question = app.getQuestionBank().getListOfQuestions().get(indexnum).getQuestion();
        questionlabel.setText("Question: " + question);
        useranswer.get(0).setText("");
    }

    public void submitButtonsq() {
        panel.add(useranswer.get(0));
        submitBsq = new JButton("Submit");
        panel.add(submitBsq);
        submitBsq.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                answerchecker();
            }
        });
    }

    public void answerchecker() {

        String inputanswer = useranswer.get(0).getText();
        String correctAnswer = app.getQuestionBank().getListOfQuestions().get(qnum).getCorrectanswer();
        if (inputanswer.equals(correctAnswer)) {
            new SuccessfulPage();
            points += app.getQuestionBank().getListOfQuestions().get(qnum).getAssignedpoints();
            pointsLabel.setText("Total Points: " + points);
        } else if (!inputanswer.equals(correctAnswer)) {
            new Unsuccessfulpage();
            pointsLabel.setText("Total Points: " + points);
        }
        qnum += 1;

        if (qnum < app.getQuestionBank().getListOfQuestions().size()) {
            showq(qnum);
        } else {
            statusLabelsq.setText("You have finished the quiz, your total score is " + this.points);

        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        new MainMenuGUI2();
    }

    public App getApp() {
        return this.app;
    }
}