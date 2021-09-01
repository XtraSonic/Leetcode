package dailies.arrayNesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class ArrayNestingTest {
    ArrayNesting arrayNesting;

    @Test
    void testExample1() {
        assertEquals(4, arrayNesting.arrayNesting(new int[]{5, 4, 0, 3, 1, 6, 2}));
    }

    @Test
    void testExample2() {
        assertEquals(1, arrayNesting.arrayNesting(new int[]{0, 1, 2}));
    }
}
