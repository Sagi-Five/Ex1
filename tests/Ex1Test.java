import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v, 11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v, 2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v, v2);
        assertTrue(Ex1.equals(s10, s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for (int i = 0; i < good.length; i = i + 1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for (int i = 0; i < not_good.length; i = i + 1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }

    @Test
    void int2NumberTest() {
        assertEquals("101b2", Ex1.int2Number(5, 2));
        assertEquals("AbG", Ex1.int2Number(10, 16));
        assertEquals("", Ex1.int2Number(-1, 2));
        assertEquals("", Ex1.int2Number(3, 20));
        // implement this test
    }

    @Test
    void maxIndexTest() {
        String[] arr = {"5bA", "101b2", "AbG"};
        assertEquals(2, Ex1.maxIndex(arr));
    }

    @Test
    void number2IntTest() {
        assertEquals(5, Ex1.number2Int("101b2"));
        assertEquals(10, Ex1.number2Int(String.valueOf( "10bA")));
        assertEquals(-1, Ex1.number2Int(("123b")));
        assertEquals(-1, Ex1.number2Int("XYZb10"));
    }

    @Test
    void convertToIntTest() {
        assertEquals(5, Ex1.convertToInt('5'));
        assertEquals(10, Ex1.convertToInt((char) 'A'));
        assertEquals(-1, Ex1.convertToInt('H'));

    }

    @Test
    void testEqualsTest() {
        assertTrue(Ex1.equals("101b2", "101b2"));
        assertFalse(Ex1.equals("101b2", "10b10"));
    }
}