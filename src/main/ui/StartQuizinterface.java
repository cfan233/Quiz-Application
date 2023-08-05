package ui;

import model.Question;
import ui.imagerelated.SuccessfulPage;
import ui.imagerelated.Unsuccessfulpage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StartQuizinterface extends JFrame {
    private int points = 0;
    private JLabel statusLabelsq = new JLabel("Please insert your answer: ");
    private JLabel pointsLabel = new JLabel("Total Points: " + points);
    private JLabel questionlabel = new JLabel();
    private JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

    private List<JTextField> useranswer = new ArrayList<>();
    private JButton submitBsq;

    private App app = new App();
    private int qnum = 0;


    public StartQuizinterface() throws FileNotFoundException {
        super("Start Quiz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        panel.add(statusLabelsq, BorderLayout.NORTH);
        panel.add(pointsLabel, BorderLayout.NORTH);
        panel.add(questionlabel,  BorderLayout.CENTER);



        initializetextbox();
        submitButton();
        showq(qnum);
        add(panel);
        pack();
        setVisible(true);
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

    public void submitButton() {
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
        new StartQuizinterface();
    }


}
