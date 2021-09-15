package dailies.longestTurbulentSubarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class LongestTurbulentSubarrayTest {
    LongestTurbulentSubarray longestTurbulentSubarray;

    @Test
    void testExample1() {
        assertEquals(5, longestTurbulentSubarray.maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9}));
    }

    @Test
    void testExample2() {
        assertEquals(2, longestTurbulentSubarray.maxTurbulenceSize(new int[]{4, 8, 12, 16}));
    }

    @Test
    void testExample3() {
        assertEquals(1, longestTurbulentSubarray.maxTurbulenceSize(new int[]{100}));
    }
}
