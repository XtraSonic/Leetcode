package dailies.countGoodNodesInBinaryTree;

import commonUtilities.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class CountGoodNodesInBinaryTreeTest {
    CountGoodNodesInBinaryTree countGoodNodesInBinaryTree;

    @Test
    void testExample1() {
        evaluateCountGoodNodesInBinaryTree(4, new Integer[]{3, 1, 4, 3, null, 1, 5});
    }

    @Test
    void testExample2() {
        evaluateCountGoodNodesInBinaryTree(3, new Integer[]{3, 3, null, 4, 2});
    }

    @Test
    void testExample3() {
        evaluateCountGoodNodesInBinaryTree(1, new Integer[]{1});
    }

    private void evaluateCountGoodNodesInBinaryTree(int expected, Integer[] integers) {
        assertEquals(expected, countGoodNodesInBinaryTree.goodNodes(TreeNode.createFromArray(integers)));
    }
}
