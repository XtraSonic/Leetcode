package dailies.maximumProductOfSplittedBinaryTree;

import commonUtilities.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class MaximumProductOfSplittedBinaryTreeTest {
    MaximumProductOfSplittedBinaryTree maximumProductOfSplittedBinaryTree;

    @Test
    void testExample1() {
        evaluateMaximumProductOfSplittedBinaryTree(110, new Integer[]{1, 2, 3, 4, 5, 6});
    }

    @Test
    void testExample2() {
        evaluateMaximumProductOfSplittedBinaryTree(90, new Integer[]{1, null, 2, 3, 4, null, null, 5, 6});
    }

    @Test
    void testExample3() {
        evaluateMaximumProductOfSplittedBinaryTree(1025, new Integer[]{2, 3, 9, 10, 7, 8, 6, 5, 4, 11, 1});
    }

    @Test
    void testExample4() {
        evaluateMaximumProductOfSplittedBinaryTree(1, new Integer[]{1, 1});
    }

    private void evaluateMaximumProductOfSplittedBinaryTree(int expected, Integer[] integers) {
        assertEquals(expected, maximumProductOfSplittedBinaryTree.maxProduct(TreeNode.createFromArray(integers)));
    }
}
