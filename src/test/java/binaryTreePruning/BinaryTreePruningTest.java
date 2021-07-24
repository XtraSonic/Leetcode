package binaryTreePruning;

import dailies.binaryTreePruning.BinaryTreePruning;
import dailies.binaryTreePruning.TreeNode;
import org.junit.jupiter.api.Test;

public abstract class BinaryTreePruningTest {
    BinaryTreePruning binaryTreePruning;

    @Test
    void test_1n001() {
        Integer[] input = {1, null, 0, 0, 1};
        Integer[] expectedOutput = {1, null, 0, null, 1};
        evaluateBinaryTreePruning(input, expectedOutput);
    }

    @Test
    void test_1010001() {
        Integer[] input = {1, 0, 1, 0, 0, 0, 1};
        Integer[] expectedOutput = {1, null, 1, null, 1};
        evaluateBinaryTreePruning(input, expectedOutput);
    }

    @Test
    void test_11011010() {
        Integer[] input = {1, 1, 0, 1, 1, 0, 1, 0};
        Integer[] expectedOutput = {1, 1, 0, 1, 1, null, 1};
        evaluateBinaryTreePruning(input, expectedOutput);
    }

    private void evaluateBinaryTreePruning(Integer[] input, Integer[] expectedOutput) {
        TreeNode root = TreeNode.createFromArray(input);
        TreeNode prunedTree = binaryTreePruning.pruneTree(root);
        TreeNodeTest.compareTreeNodeToIntegerArray(prunedTree, expectedOutput);
    }
}
