package dailies.convertSortedArrayToBinarySearchTree;

import commonUtilities.TreeNode;
import commonUtilities.TreeNodeTest;
import org.junit.jupiter.api.Test;

public abstract class ConvertSortedArrayToBinarySearchTreeTest {
    ConvertSortedArrayToBinarySearchTree converter;

    @Test
    void test_example1() {
        int[] input = {-10, -3, 0, 5, 9};
        TreeNode result = converter.sortedArrayToBST(input);
        TreeNodeTest.compareTreeNodeToIntegerArray(result, 0, -3, 9, -10, null, 5);
    }

    @Test
    void test_example2() {
        int[] input = {1, 3};
        TreeNode result = converter.sortedArrayToBST(input);
        TreeNodeTest.compareTreeNodeToIntegerArray(result, 3, 1);
    }

    @Test
    void test_evenInput() {
        int[] input = {-10, -3, -1, 0, 5, 9};
        TreeNode result = converter.sortedArrayToBST(input);
        TreeNodeTest.compareTreeNodeToIntegerArray(result, 0, -3, 9, -10, -1, 5);
    }
}
