package dailies.slowestKey;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class SlowestKeyTest {
    SlowestKey slowestKey;

    @Test
    void testExample1() {
        assertEquals('c', slowestKey.slowestKey(new int[]{9, 29, 49, 50}, "cbcd"));
    }

    @Test
    void testExample2() {
        assertEquals('a', slowestKey.slowestKey(new int[]{12, 23, 36, 46, 62}, "spuda"));
    }
}
