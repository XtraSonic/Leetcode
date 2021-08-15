package dailies.minimumWindowSubstring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class MinimumWindowSubstringTest {
    MinimumWindowSubstring minimumWindowSubstring;

    @Test
    void testExample1() {
        assertEquals("BANC", minimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));
    }

    @Test
    void testExample2() {
        assertEquals("a", minimumWindowSubstring.minWindow("a", "a"));
    }

    @Test
    void testExample3() {
        assertEquals("", minimumWindowSubstring.minWindow("a", "aa"));
    }
}
