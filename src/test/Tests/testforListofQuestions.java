package Tests;

import model.ListOfQuestions;
import model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.App;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testforListofQuestions {

    ListOfQuestions loq;

    @BeforeEach
    void runbefore() {
        loq = new ListOfQuestions();
    }
    @Test
    void testaddQuestion(){
        Question q1 = new Question("What is the capital of Canada?", "Ottawa", 1);
        Question q2 = new Question("Which city is UBC at?", "Vancouver", 2);
        Question q3 = new Question("Who is the prime minister of Canada?", "Justin Trudeau", 3);
        Question q4 = new Question("Who owns Tesla?","Elon Musk", 1);

        loq.getListOfQuestions().size();


        assertEquals(0, loq.getListOfQuestions().size());
        loq.addQuestion(q1);
        assertEquals(q1, loq.getListOfQuestions().get(0));
        assertEquals(1, loq.getListOfQuestions().size());

        loq.addQuestion(q2);
        loq.addQuestion(q3);
        loq.addQuestion(q4);
        loq.addQuestion(q1);
        assertEquals(q2, loq.getListOfQuestions().get(1));
        assertEquals(q3, loq.getListOfQuestions().get(2));
        assertEquals(q4, loq.getListOfQuestions().get(3));
        assertEquals(q1, loq.getListOfQuestions().get(4));
        assertEquals(5, loq.getListOfQuestions().size());
    }

    @Test
    void testremoveQuestion(){
        Question q1 = new Question("What is the capital of Canada?", "Ottawa", 1);
        Question q2 = new Question("Which city is UBC at?", "Vancouver", 2);
        Question q3 = new Question("Who is the prime minister of Canada?", "Justin Trudeau", 3);
        Question q4 = new Question("Who owns Tesla?","Elon Musk", 1);



        loq.addQuestion(q1);
        loq.addQuestion(q2);
        loq.addQuestion(q3);
        loq.addQuestion(q4);
        assertEquals(4, loq.getListOfQuestions().size());

        loq.removeQuestion(q1);
        assertEquals(3, loq.getListOfQuestions().size());
        assertEquals(q2, loq.getListOfQuestions().get(0));

        loq.removeQuestion(q2);
        loq.removeQuestion(q3);

        assertEquals(1, loq.getListOfQuestions().size());
        assertEquals(q4, loq.getListOfQuestions().get(0));

        loq.removeQuestion(q4);
        assertEquals(0, loq.getListOfQuestions().size());
        assertTrue(loq.getListOfQuestions().isEmpty());




    }
}
