package Tests;

import model.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Event class
 */
public class EventTest {
    private Event e;
    private Event a;
    private Event c;
    private Date d;

    //NOTE: these tests might fail if time at which line (2) below is executed
    //is different from time that line (1) is executed.  Lines (1) and (2) must
    //run in same millisecond for this test to make sense and pass.

    @BeforeEach
    public void runBefore() {
        e = new Event("x");  // (1)
        a = new Event("x");
        d = Calendar.getInstance().getTime();   // (2)
        c = new Event("Sensor open at doo");

    }

    @Test
    public void testEvent() {
        assertEquals("x", e.getDescription());
        assertEquals(d, e.getDate());
    }

    @Test
    public void testequalsnull() {
        assertFalse(e.equals(null));
    }
    @Test
    public void testequalsnotsamesubject() {
        assertFalse(e.equals(d));
        assertFalse(c.equals("123"));
    }

    @Test
    public void testequalsnotsame() {
        assertFalse(e.equals(c));
    }

    @Test
    public void testHashCode() {
        assertNotEquals(e.hashCode(), c.hashCode());
        assertEquals(a.hashCode(), e.hashCode());
    }

    @Test
    public void testequalscorrect() {
        assertTrue(a.equals(e));
        assertFalse(a.equals(c));
    }





    @Test
    public void testToString() {
        assertEquals(d.toString() + "\n" + "x", e.toString());
    }
}
