package dailies.threeSumClosest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class ThreeSumClosestTest {
    ThreeSumClosest threeSumClosest;

    @Test
    void test_example1() {
        int[] input = {-1, 2, 1, -4};
        assertEquals(2, threeSumClosest.threeSumClosest(input, 1));
    }

    @Test
    void test() {
        int[] input = {1, 2, 5, 10, 11};
        testResult(13, 12, input);
    }

    @Test
    void test2() {
        int[] input = {0, 2, 1, -3};
        testResult(0, 1, input);
    }

    public void testResult(int expectedResult, int[] input) {
        testResult(expectedResult, expectedResult, input);
    }

    public void testResult(int expectedResult, int target, int[] input) {
        assertEquals(expectedResult, threeSumClosest.threeSumClosest(input, target));
    }
}
