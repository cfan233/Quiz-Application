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

public class InsertQuestionInterface extends JFrame {
    private static String STATUS = "Please input the appropriate values";
    private JLabel statusLabel;
    private JPanel buttonPanel = new JPanel(new GridLayout(4, 2, 10, 10));

    private JTextField questioninput;
    private JTextField answerinput;
    private JTextField scoreinput;
    private JButton submitB;
    protected MainMenuGUI mmg = new MainMenuGUI(1);



    public InsertQuestionInterface() throws FileNotFoundException {
        super("Insert Question");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        statusLabel = new JLabel(STATUS);
        add(statusLabel, BorderLayout.NORTH);

        add(buttonPanel, BorderLayout.CENTER);
        inputQ();
        inputA();
        inputS();
        submitButton();

        pack();
        setVisible(true);
    }

    public void inputQ() {
        JLabel labelforinputq = new JLabel("Please enter your question:");
        questioninput = new JTextField(50);
        buttonPanel.add(labelforinputq);
        buttonPanel.add(questioninput);
    }

    public void inputA() {
        JLabel labelforinputa = new JLabel("Please enter the corresponding answer for the question "
                + "you have inserted");
        answerinput = new JTextField(50);
        buttonPanel.add(labelforinputa);
        buttonPanel.add(answerinput);
    }

    public void inputS() {
        JLabel labelforinputS = new JLabel("Please assign points from scale 1-10 for answering this "
                + "question correctly " + "(integer only)");
        scoreinput = new JTextField(50);
        buttonPanel.add(labelforinputS);
        buttonPanel.add(scoreinput);

    }

    public void submitButton() {
        submitB = new JButton("Submit");
        submitB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insertQreqiurement();
            }
        });
        buttonPanel.add(new JLabel());
        buttonPanel.add(submitB);
    }

    public void insertQreqiurement() {
        String questionstring = questioninput.getText();
        String anwserstring = answerinput.getText();
        int scoreint;
        try {
            scoreint = Integer.parseInt(scoreinput.getText());
            if (!(mmg.app.questionBank.isquestioninbank(questionstring))) {
                if (!(scoreint < 1 || scoreint > 10)) {
                    Question newq = new Question(questionstring, anwserstring, scoreint);
                    mmg.app.questionBank.addQuestion(newq);
                    new Questionhasbeenaddedimage();
                } else {
                    statusLabel.setText("Integer input is not within the bound 1-10");
                }
            } else {
                statusLabel.setText("Sorry the question you are trying to implement is already in the "
                        + "question bank and the question bank does not allow duplicates");
                questioninput.setText("");
            }
        } catch (NumberFormatException c) {
            statusLabel.setText("Please enter integer");
        }
    }




    public static void main(String[] args) throws FileNotFoundException {
        new InsertQuestionInterface();
    }




}
