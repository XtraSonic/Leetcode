package dailies.maxConsecutiveOnes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class MaxConsecutiveOnesTest {
    MaxConsecutiveOnes maxConsecutiveOnes;

    @Test
    void testExample1() {
        assertEquals(3, maxConsecutiveOnes.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }

    @Test
    void testExample2() {
        assertEquals(2, maxConsecutiveOnes.findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1}));
    }
}
