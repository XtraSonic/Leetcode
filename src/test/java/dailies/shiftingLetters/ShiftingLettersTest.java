package dailies.shiftingLetters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class ShiftingLettersTest {
    ShiftingLetters shiftingLetters;

    @Test
    void testExample1() {
        assertEquals("rpl", shiftingLetters.shiftingLetters("abc", new int[]{3, 5, 9}));
    }

    @Test
    void testExample2() {
        assertEquals("gfd", shiftingLetters.shiftingLetters("aaa", new int[]{1, 2, 3}));
    }

    @Test
    void testZRollOver() {
        assertEquals("a", shiftingLetters.shiftingLetters("z", new int[]{1}));
    }
}
