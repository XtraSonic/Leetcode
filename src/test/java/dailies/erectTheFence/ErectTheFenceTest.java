package dailies.erectTheFence;

import org.junit.jupiter.api.Test;
import utilities.TestUtils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public abstract class ErectTheFenceTest {
    ErectTheFence erectTheFence;

    @Test
    void testExample1() {
        TestUtils.areTheSameOutOfOrder(Arrays.asList(
                new int[]{1, 1},
                new int[]{2, 0},
                new int[]{3, 3},
                new int[]{2, 4},
                new int[]{4, 2}),
                Arrays.asList(erectTheFence.outerTrees(
                        new int[][]{
                                new int[]{1, 1},
                                new int[]{2, 2},
                                new int[]{2, 0},
                                new int[]{2, 4},
                                new int[]{3, 3},
                                new int[]{4, 2}
                        }
                )));
    }


    @Test
    void testExample2() {
        assertArrayEquals(new int[][]{
                        new int[]{1, 2},
                        new int[]{2, 2},
                        new int[]{4, 2}},
                erectTheFence.outerTrees(
                        new int[][]{
                                new int[]{1, 2},
                                new int[]{2, 2},
                                new int[]{4, 2}
                        }
                ));
    }
}
