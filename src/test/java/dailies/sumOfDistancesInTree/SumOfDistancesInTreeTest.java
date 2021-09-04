package dailies.sumOfDistancesInTree;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public abstract class SumOfDistancesInTreeTest {
    SumOfDistancesInTree sumOfDistancesInTree;

    @Test
    void testExample1() {
        int[] actual = sumOfDistancesInTree.sumOfDistancesInTree(6, new int[][]{
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{2, 3},
                new int[]{2, 4},
                new int[]{2, 5},
        });
        int[] expected = {8, 12, 6, 10, 10, 10};
        System.out.println(Arrays.toString(actual));
        System.out.println(Arrays.toString(expected));
        assertArrayEquals(expected,
                actual);
    }

    @Test
    void testExample2() {
        assertArrayEquals(new int[]{0},
                sumOfDistancesInTree.sumOfDistancesInTree(1, new int[][]{
                }));
    }

    @Test
    void testExample3() {
        assertArrayEquals(new int[]{1, 1},
                sumOfDistancesInTree.sumOfDistancesInTree(2, new int[][]{
                        new int[]{0, 1},
                }));
    }
}
