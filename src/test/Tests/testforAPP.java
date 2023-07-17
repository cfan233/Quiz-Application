package Tests;
import model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.App;
import org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class testforAPP {
    App a1;

    @BeforeEach
    void runbefore() {
        a1 = new App();
    }

    @Test
    void testaddNewQuestions(){
        Question q1 = new Question("What is the capital of Canada", "Ottawa", 1);
        Question q2 = new Question("Which city is UBC at", "Vancouver", 2);
        Question q3 = new Question("Who is the prime minister of Canada", "Justin Treuau", 3);
        Question q4 = new Question("Who owns Tesla","Elon Musk", 1);


        a1.addNewQuestion(q1);
        a1.addNewQuestion(q2);
        a1.addNewQuestion(q3);
        a1.addNewQuestion(q4);

        assertEquals(4, a1.getlistOfQuestion().getListOfQuestions().size());
        assertEquals(q1, a1.getlistOfQuestion().getListOfQuestions().get(0));
        assertEquals(q2, a1.getlistOfQuestion().getListOfQuestions().get(1));
        assertEquals(q3, a1.getlistOfQuestion().getListOfQuestions().get(2));
        assertEquals(q4, a1.getlistOfQuestion().getListOfQuestions().get(3));

        a1.addNewQuestion(q2);
        assertEquals(4, a1.getlistOfQuestion().getListOfQuestions().size());
        assertEquals(q2, a1.getlistOfQuestion().getListOfQuestions().get(3));
        assertEquals(q3, a1.getlistOfQuestion().getListOfQuestions().get(1));

    }
/*
    @Test
    void testshowquestion(){
        Question q1 = new Question("What is the capital of Canada", "Ottawa", 1);
        Question q2 = new Question("Which city is UBC at", "Vancouver", 2);
        Question q3 = new Question("Who is the prime minister of Canada", "Justin Treuau", 3);
        Question q4 = new Question("Who owns Tesla","Elon Musk", 1);

        a1.addNewQuestion(q1);
        a1.addNewQuestion(q2);
        a1.addNewQuestion(q3);
        a1.addNewQuestion(q4);

        String message = "What is the capital of Canada" + "Which city is UBC at" + "Who is the prime minister of Canada" + "Who owns Tesla";
        System.out.println(message);
        a1.showquestion().toString;


        String message1 =

        assertEquals(message, a1.showquestion());


    }*/

}


