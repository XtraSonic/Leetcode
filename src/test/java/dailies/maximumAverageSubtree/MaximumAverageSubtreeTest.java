package dailies.maximumAverageSubtree;

import commonUtilities.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class MaximumAverageSubtreeTest {
    MaximumAverageSubtree maximumAverageSubtree;

    @Test
    void testExample1() {
        evaluateMaximumAverageSubtree(6, new Integer[]{5, 6, 1});
    }

    @Test
    void testExample2() {
        evaluateMaximumAverageSubtree(1, new Integer[]{0, null, 1});
    }

    @Test
    void testNonLeafResult() {
        evaluateMaximumAverageSubtree(10, new Integer[]{23, 6, 1});
    }

    private void evaluateMaximumAverageSubtree(int expected, Integer[] integers) {
        assertEquals(expected, maximumAverageSubtree.maximumAverageSubtree(TreeNode.createFromArray(integers)));
    }
}
