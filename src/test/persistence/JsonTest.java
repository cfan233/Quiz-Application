package persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import model.Question;

// Citation: WorkRoomAPP
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

public class JsonTest {
    protected void checkQuestion(String q, String ca, int p, Question ques) {
        assertEquals(q, ques.getQuestion());
        assertEquals(ca, ques.getCorrectanswer());
        assertEquals(p, ques.getAssignedpoints());
    }
}

