package Tests;

import model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testforQuestion {

    Question q1;
    Question q2;
    Question q3;

    @BeforeEach
    void runbefore() {
        q1 = new Question("What is the capital of Canada?", "Ottawa", 1);
        q2 = new Question("Which city is UBC at", "Vancouver", 2);
        q3 = new Question("", "", 0);
    }

    @Test
    public void testgetCorrectanswer(){
        assertEquals("Ottawa", q1.getCorrectanswer());
        assertEquals("Vancouver", q2.getCorrectanswer());
        assertEquals("", q3.getCorrectanswer());
    }

    @Test
    public void testgetQuestion(){
        assertEquals("What is the capital of Canada?", q1.getQuestion());
        assertEquals("Which city is UBC at", q2.getQuestion());
        assertEquals("", q3.getQuestion());
    }

    @Test
    public void testgetAssignedpoints(){
        assertEquals(1, q1.getAssignedpoints1());
        assertEquals(2, q2.getAssignedpoints1());
        assertEquals(0, q3.getAssignedpoints1());
    }

    @Test
    public void testgetCorrectanswer1(){
        assertEquals("Ottawa", q1.getCorrectanswer1());
        assertEquals("Vancouver", q2.getCorrectanswer1());
        assertEquals("", q3.getCorrectanswer1());
    }

    @Test
    public void testgetQuestion1(){
        assertEquals("What is the capital of Canada?", q1.getQuestion1());
        assertEquals("Which city is UBC at", q2.getQuestion1());
        assertEquals("", q3.getQuestion1());
    }

    @Test
    public void testgetAssignedpoints1(){
        assertEquals(1, q1.getAssignedpoints1());
        assertEquals(2, q2.getAssignedpoints1());
        assertEquals(0, q3.getAssignedpoints1());
    }
}



